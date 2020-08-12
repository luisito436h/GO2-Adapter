package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_JUMPSHIPTEAMINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class JumpShipTeamInfo {
  public static final short LENGTH = 32 + MsgTypes.MAX_NAME;
  
  public long userId;
  public String userName;
  public int shipTeamId;
  public int fromGalaxyId;
  public int toGalaxyId;
  public int spareTime;
  public int totalTime;
  public byte fromGalaxyMapId;
  public byte toGalaxyMapId;
  public byte type;
  public byte galaxyType;
  
  public JumpShipTeamInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.fromGalaxyId = b.readInt();
    this.toGalaxyId = b.readInt();
    this.spareTime = b.readInt();
    this.totalTime = b.readInt();
    this.fromGalaxyMapId = b.readByte();
    this.toGalaxyMapId = b.readByte();
    this.type = b.readByte();
    this.galaxyType = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
