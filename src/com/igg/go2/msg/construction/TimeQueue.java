package com.igg.go2.msg.construction;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_TIMEQUEUE_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TimeQueue {
  public static final short LENGTH = 8;
  
  public int type;
  public int spareTime;
  
  public TimeQueue() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.type = b.readInt();
    this.spareTime = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.type);
    b.writeInt(this.spareTime);
  }
  
  public void release() {
     //do nothing
  }
}
