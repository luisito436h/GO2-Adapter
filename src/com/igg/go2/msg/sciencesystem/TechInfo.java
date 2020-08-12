package com.igg.go2.msg.sciencesystem;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_TECHINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TechInfo {
  public static final short LENGTH = 4;
  
  public short techId;
  public short levelId;
  
  
  public TechInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.techId = b.readShort();
    this.levelId = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeShort(this.techId);
    b.writeShort(this.levelId);
  }
  
  public void release() {
     //do nothing
  }
}
