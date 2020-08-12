package com.igg.go2.msg.shipmodel;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CREATESHIPINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CreateShipInfo {
  public static final short LENGTH = 16;
  
  public int shipModelId;
  public int needTime;
  public int num;
  public int incSpeed;
  
  public CreateShipInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.shipModelId = b.readInt();
    this.needTime = b.readInt();
    this.num = b.readInt();
    this.incSpeed = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.shipModelId);
    b.writeInt(this.needTime);
    b.writeInt(this.num);
    b.writeInt(this.incSpeed);
  }
  
  public void release() {
     //do nothing
  }
}
