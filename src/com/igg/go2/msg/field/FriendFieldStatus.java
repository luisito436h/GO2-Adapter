package com.igg.go2.msg.field;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FRIENDFIELDSTATUS_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FriendFieldStatus {
  public static final short LENGTH = 24;
  
  public long userId;
  public int guid;
  public int galaxyMapId;
  public int galaxyId;
  public short reserve;
  public byte helpFlag;
  public byte thieveFlag;
  
  public FriendFieldStatus() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.guid = b.readInt();
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.reserve = b.readShort();
    this.helpFlag = b.readByte();
    this.thieveFlag = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
