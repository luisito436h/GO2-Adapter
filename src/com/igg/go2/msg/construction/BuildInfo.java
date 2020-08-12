package com.igg.go2.msg.construction;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_BUILDINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class BuildInfo {
  public static final short LENGTH = 12;
  
  public int spareTime;
  public short posX;
  public short posY;
  public short indexId;
  public byte buildingId;
  public byte levelId;
  
  public BuildInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.spareTime = b.readInt();
    this.posX = b.readShort();
    this.posY = b.readShort();
    this.indexId = b.readShort();
    this.buildingId = b.readByte();
    this.levelId = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.spareTime);
    b.writeShort(this.posX);
    b.writeShort(this.posY);
    b.writeShort(this.indexId);
    b.writeByte(this.buildingId);
    b.writeByte(this.levelId);
  }
  
  public void release() {
     //do nothing
  }
}
