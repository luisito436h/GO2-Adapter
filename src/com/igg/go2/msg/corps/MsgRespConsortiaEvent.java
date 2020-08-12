package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaEvent extends MsgHead {
  public short eventCount;
  public byte type;
  public byte dataLen;
  public Event[] data;
  
  public MsgRespConsortiaEvent() {
    super();
    
    this.data = new Event[9];
    for(int idx = 0; idx < 9; idx++) {
      this.data[idx] = new Event();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAEVENT;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.eventCount = b.readShort();
    this.type = b.readByte();
    this.dataLen = b.readByte();
    for(int idx = 0; idx < 9; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + Event.LENGTH * 9;
  }
  
  public void release() {
    for(int idx = 9 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
