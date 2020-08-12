package com.igg.go2.msg.sciencesystem;

import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class Props {
  public static final short LENGTH = 8;
  
  public short propsId;
  public short propsNum;
  public short propsLockNum;
  public byte storageType;
  public byte reserve;
  
  public Props() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.propsId = b.readShort();
    this.propsNum = b.readShort();
    this.propsLockNum = b.readShort();
    this.storageType = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeShort(this.propsId);
    b.writeShort(this.propsNum);
    b.writeShort(this.propsLockNum);
    b.writeByte(this.storageType);
    b.writeByte(this.reserve);
  }
  
  public void release() {
     //do nothing
  }
}
