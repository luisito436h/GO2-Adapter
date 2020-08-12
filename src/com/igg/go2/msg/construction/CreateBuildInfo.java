package com.igg.go2.msg.construction;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CREATEBUILDINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CreateBuildInfo {
  public static final short LENGTH = 8;
  
  public int indexId;
  public int spareTime;
  
  public CreateBuildInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.indexId = b.readInt();
    this.spareTime = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.indexId);
    b.writeInt(this.spareTime);
  }
  
  public void release() {
     //do nothing
  }
}
