package net.skimnerphi.go2.network;

import net.skimnerphi.go2.util.*;
import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author SkimnerPhi
 */
public class Connection {
  /**
   * IP for connecting to the EU login servers
   */
  public static final String IP_EU = "52.28.78.171";
  /**
   * IP for connecting to the PH login servers
   */
  public static final String IP_PH = "192.243.40.21";
  /**
   * IP for connecting to the US login servers
   */
  public static final String IP_US = "192.243.40.22";
  /**
   * Default port for connecting to login servers.
   */
  public static final int PORT_DEFAULT = 443;
  /**
   * Standard fallback port for connecting to login servers.
   */
  public static final int PORT_BACKUP1 = 458;
  /**
   * Standard fallback port for connecting to login servers.
   */
  public static final int PORT_BACKUP2 = 5050;
  /**
   * Port for connecting to EU login server using keyless login hack.
   */
  public static final int PORT_HACKED = 5050;
  
  //friendly name for use in logging
  private final String debugName;
  //flag for printing all message data to console
  public boolean verbose;
  
  //account facebook id
  private final long facebookId;
  //account security token
  private final String loginKey;
  //in-game id
  private int gameUserId;
  
  private GameAuth authInfo;
  
  private Socket serverSocket;
  private OutputStream gameOut;
  private InputStream gameIn;
  
  private MessageFactory msgFac;
  //associated request instance
  private Request req;
  //associated response instance
  private Response resp;
  
  //counter for sent message sequence IDs
  private int seqId;
  
  /**
   * Create a new Connection.
   * @param debugName Friendly name for use in logging
   * @param fbId Facebook ID for the account
   * @param key Session key for the account
   */
  public Connection(String debugName, long fbId, String key) {
    this.debugName = debugName;
    this.facebookId = fbId;
    this.loginKey = key;
    
    this.resp = new Response(this);
    this.req = new Request(this);
  }
  /**
   * Create a new Connection.
   * @param fbId Facebook ID for the account
   * @param key Session key for the account
   */
  public Connection(long fbId, String key) {
    this.debugName = Long.toString(fbId, 16);
    this.facebookId = fbId;
    this.loginKey = key;
    
    this.resp = new Response(this);
    this.req = new Request(this);
  }
  /**
   * Create a new keyless Connection. Connections initialized without a session key can only connect to the EU servers using the hacked port.
   * @param debugName Friendly name for use in logging
   * @param fbId Facebook ID for the account
   */
  public Connection(String debugName, long fbId) {
    this.debugName = debugName;
    this.facebookId = fbId;
    this.loginKey = generateFalseToken();
    
    this.resp = new Response(this);
    this.req = new Request(this);
  }
  /**
   * Create a new keyless Connection. Connections initialized without a session key can only connect to the EU servers using the hacked port.
   * @param fbId Facebook ID for the account
   */
  public Connection(long fbId) {
    this.debugName = Long.toString(fbId, 16);
    this.facebookId = fbId;
    this.loginKey = generateFalseToken();
    
    this.resp = new Response(this);
    this.req = new Request(this);
  }
  
  private String generateFalseToken() {
    String ret = "";
    final String alphabet = "0123456789abcdef";
    for(int i = 0; i < 32; i++) {
      ret += alphabet.charAt((int)(Math.random() * alphabet.length()));
    }
    return ret;
  }
  
  /**
   * Connect to the specified login server and authenticate
   * @param ip Login IP
   * @param port Login port
   * @throws IOException 
   */
  public void login(String ip, int port) throws IOException {
    loginRegister(ip, port, null);
  }
  /**
   * Connect to the specified login server and authenticate a new account
   * @param ip Login IP
   * @param port Login port
   * @param username In-game name to use
   * @throws IOException 
   */
  public void loginRegister(String ip, int port, String username) throws IOException {
    try(Socket soc = new Socket(ip, port)) {
      OutputStream out = soc.getOutputStream();
      InputStream in = soc.getInputStream();
      
      //Skips the <cross-domain-policy> packet that is sent
      for(int idx = 0; idx < 91; idx++) {
        in.read();
      }
      
      MsgClientLoginToL req_clientLoginToL = new MsgClientLoginToL();
      req_clientLoginToL.seqId = this.seqId;
      req_clientLoginToL.userId = this.facebookId;
      req_clientLoginToL.sessionKey = this.loginKey;
      if(username != null) {
        req_clientLoginToL.registerFlag = 1;
        req_clientLoginToL.registerName = username;
      }
      
      ByteArray bArr = new ByteArray();
      req_clientLoginToL.writeBuf(bArr);
      out.write(bArr.data());
      
      if(verbose) {
        System.out.println("[" + debugName + ":network] send MSG_CLIENT_LOGINTOL = " + Debug.jsonify(req_clientLoginToL));
      }
      
      //This originally used Connection::read() instead, but it is easier to add explicit handling for the messages that can actually come from the login server
      int b0 = in.read();
      int b1 = in.read();
      int msgLen = ((b1 & 0xFF) << 8) | b0 & 0xFF;
      
      byte[] b = new byte[msgLen];
      b[0] = (byte)b0;
      b[1] = (byte)b1;
      
      msgLen -= 2;
      int pos = 2;
      
      while(msgLen > 0) {
        int read = in.read(b, pos, msgLen);
        msgLen -= read;
        pos += read;
      }
      short msgType = (short)(((b[3] & 0xFF) << 8) | b[2] & 0xFF);
      
      switch(msgType) {
        case MsgTypes.MSG_LOGINSERVER_VALIDATE:
          MsgLoginServerValidate resp_loginServerValidate = new MsgLoginServerValidate();
          resp_loginServerValidate.readBuf(new ByteArray(b));
          
          if(verbose) {
            System.out.println("[" + debugName + ":network] read MSG_LOGINSERVER_VALIDATE = " + Debug.jsonify(resp_loginServerValidate));
          }
          
          System.out.println("[" + debugName + ":connection] Login authenticated");
          
          this.authInfo = new GameAuth(
                  resp_loginServerValidate.ip,
                  resp_loginServerValidate.port,
                  resp_loginServerValidate.checkOutText,
                  username);
          
          break;
        default:
          break;
      }
    }
  }
  
  /**
   * Check if the associated account has been logged in
   * @return Whether the account has been successfully authenticated
   */
  public boolean isAuthenticated() {
    return this.authInfo != null;
  }
  
  /**
   * Connect to the game server. This should only be called <i>after</i> the authentication process
   * @throws IOException 
   */
  public void connect() throws IOException {
    if(this.authInfo == null) {
      throw new IOException("Not authenticated");
    }
    
    this.serverSocket = new Socket(this.authInfo.ip, this.authInfo.port);
    
    this.gameOut = this.serverSocket.getOutputStream();
    this.gameIn = this.serverSocket.getInputStream();
    
    MsgClientLoginToG req_clientLoginToG = new MsgClientLoginToG();
    req_clientLoginToG.userId = this.facebookId;
    req_clientLoginToG.checkOutText = this.authInfo.checkOutText;
    req_clientLoginToG.sessionKey = this.loginKey;
    req_clientLoginToG.registerName = this.authInfo.username;
    //While never explicitly tested, I believe that setting this flag to 1 is what causes the infinite welcome mail glitch
    //It doesn't seem to hurt anything either, so leaving this is fine even if it doesn't cause the glitch
    req_clientLoginToG.registerFlag = 1;
    sendMsg(req_clientLoginToG);
    
    //If the connection fails from this point on, the account will need to be reauthenticated
    this.authInfo = null;
    
    this.msgFac = new MessageFactory();
    
    MsgGameServerLoginResp resp_gameServerLogin = (MsgGameServerLoginResp)readMsg();
    this.gameUserId = resp_gameServerLogin.guid;
    
    System.out.println("[" + debugName + ":connection] Connected");
    
    MsgRequestPlayerInfo req_playerInfo = new MsgRequestPlayerInfo();
    req_playerInfo.guid = gameUserId;
    req_playerInfo.hdFlag = resp_gameServerLogin.hdFlag;
    sendMsg(req_playerInfo);
    
    this.resp.start();
  }
  
  /**
   * Send a message object to the game server. MsgHead::seqId is automatically incremented.
   * @param mh A message object.
   * @throws IOException 
   */
  public void sendMsg(MsgHead mh) throws IOException {
    mh.seqId = seqId++;
    
    ByteArray b = new ByteArray();
    mh.writeBuf(b);
    
    this.gameOut.write(b.data());
    
    if(verbose) {
      System.out.println("[" + debugName + ":network] send " + ResourceLookup.getMessageName(mh.usType) + " = " + Debug.jsonify(mh));
    }
  }
  
  /**
   * Reads the next message from the game server.
   * @return A message object
   * @throws IOException 
   */
  public MsgHead readMsg() throws IOException {
    MsgHead msg = null;
    
    while(msg == null) {
      int b0 = this.gameIn.read();
      int b1 = this.gameIn.read();
      int msgLen = ((b1 & 0xFF) << 8) | b0 & 0xFF;

      byte[] b = new byte[msgLen];
      b[0] = (byte)b0;
      b[1] = (byte)b1;

      msgLen -= 2;
      int pos = 2;

      while(msgLen > 0) {
        int read = this.gameIn.read(b, pos, msgLen);
        msgLen -= read;
        pos += read;
      }
      short msgType = (short)(((b[3] & 0xFF) << 8) | b[2] & 0xFF);

      msg = msgFac.getMessage(b, msgType);

      if(verbose) {
        if(msg == null) {
          System.err.println("[" + debugName + ":network] read " + ResourceLookup.getMessageName(msgType) + " = skipped: no associated definition");
        } else {
          System.out.println("[" + debugName + ":network] read " + ResourceLookup.getMessageName(msgType) + " = " + Debug.jsonify(msg));
        }
      }
    }
    
    return msg;
  }
  
  /**
   * Add a MessageListener to the associated Response object.<br/>Effectively the same as calling <code>resp().addMessageListener(ml)</code>.
   */
  public void addMessageListener(MessageListener ml) {
    this.resp.addMessageListener(ml);
  }
  /**
   * Remove a MessageListener to the associated Response object.<br/>Effectively the same as calling <code>resp().addMessageListener(ml)</code>.
   */
  public void removeMessageListener(MessageListener ml) {
    this.resp.removeMessageListener(ml);
  }
  
  /**
   * End the connection to the game server
   */
  public void disconnect() {
    this.resp.interrupt();
  }
  /**
   * Called by Response when thread has closed safely
   */
  void abortConnection() {
    try {
      this.serverSocket.close();
    } catch(IOException ex) {
      //Do nothing
    }
    System.out.println("[" + debugName + ":connection] Disconnected");
  }
  
  public String debugName() {
    return this.debugName;
  }
  public long fbid() {
    return this.facebookId;
  }
  public int guid() {
    return this.gameUserId;
  }
  
  public Request req() {
    return this.req;
  }
  public Response resp() {
    return this.resp;
  }
}