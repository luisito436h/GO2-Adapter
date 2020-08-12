package com.igg.go2.msg.ship;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_BRUISESHIPINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class BruiseShipInfo {
  public static final short LENGTH = 8;
  
  public int shipModelId;
  public int num;
  
  public BruiseShipInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.shipModelId = b.readInt();
    this.num = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.shipModelId);
    b.writeInt(this.num);
  }
  
  public void release() {
     //do nothing
  }
}
