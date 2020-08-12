package com.igg.go2.msg;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_LOGINSERVER_GAMESERVERLIST_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class GameServerInfo {
  public static final short LENGTH = 8;
  
  public int userCount;
  public short onlineCount;
  public byte serverId;
  public byte reserver;
  
  public GameServerInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userCount = b.readInt();
    this.onlineCount = b.readShort();
    this.serverId = b.readByte();
    this.reserver = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.userCount);
    b.writeShort(this.onlineCount);
    b.writeByte(this.serverId);
    b.writeByte(this.reserver);
  }
  
  public void release() {
     //do nothing
  }
}
