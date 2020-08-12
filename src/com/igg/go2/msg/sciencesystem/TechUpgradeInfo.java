package com.igg.go2.msg.sciencesystem;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_TECHUPGRADEINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TechUpgradeInfo {
  public static final short LENGTH = 8;
  
  public int needTime;
  public short techId;
  public short creditFlag;
  
  public TechUpgradeInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.needTime = b.readInt();
    this.techId = b.readShort();
    this.creditFlag = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.needTime);
    b.writeShort(this.techId);
    b.writeShort(this.creditFlag);
  }
  
  public void release() {
     //do nothing
  }
}
