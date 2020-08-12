package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTimeQueue extends MsgHead {
  public int dataLen;
  public TimeQueue[] data;
  
  public MsgRespTimeQueue() {
    super();
    
    this.data = new TimeQueue[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new TimeQueue();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TIMEQUEUE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 10; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + TimeQueue.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 10 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
