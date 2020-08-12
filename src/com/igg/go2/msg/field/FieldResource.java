package com.igg.go2.msg.field;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FIELDRESOURCE_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FieldResource {
  public static final short LENGTH = 20;
  
  public int spareTime;
  public int guid;
  public int galaxyId;
  public int num;
  public byte resourceId;
  public byte status;
  public byte thieveCount;
  public byte thieveFlag;
  
  public FieldResource() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.spareTime = b.readInt();
    this.guid = b.readInt();
    this.galaxyId = b.readInt();
    this.num = b.readInt();
    this.resourceId = b.readByte();
    this.status = b.readByte();
    this.thieveCount = b.readByte();
    this.thieveFlag = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
