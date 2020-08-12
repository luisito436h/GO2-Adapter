package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFieldResourceLog extends MsgHead {
  public int dataLen;
  public FieldResourceLog[] data;
  
  public MsgRespFieldResourceLog() {
    super();
    
    this.data = new FieldResourceLog[15];
    for(int idx = 0; idx < 15; idx++) {
      this.data[idx] = new FieldResourceLog();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIELDRESOURCELOG;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 15; idx++) {
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
    return 8 + FieldResourceLog.LENGTH * 15;
  }
  
  public void release() {
    for(int idx = 15 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
