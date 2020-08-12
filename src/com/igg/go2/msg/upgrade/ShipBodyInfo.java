package com.igg.go2.msg.upgrade;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_SHIPBODYINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipBodyInfo {
  public static final short LENGTH = 8;
  
  public int bodyPartId;
  public int needTime;
  
  public ShipBodyInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.bodyPartId = b.readInt();
    this.needTime = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
