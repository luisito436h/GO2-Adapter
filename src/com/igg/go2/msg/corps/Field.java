package com.igg.go2.msg.corps;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAFIELD_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class Field {
  public static final short LENGTH = 20;
  
  public int maxShipNum;
  public int shipNum;
  public int galaxyId;
  public int needTime;
  public byte status;
  public byte level;
  public short reserve;
  
  public Field() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.maxShipNum = b.readInt();
    this.shipNum = b.readInt();
    this.galaxyId = b.readInt();
    this.needTime = b.readInt();
    this.status = b.readByte();
    this.level = b.readByte();
    this.reserve = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
