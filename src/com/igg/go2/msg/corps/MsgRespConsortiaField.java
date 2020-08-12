package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaField extends MsgHead {
  public int dataLen;
  public Field[] data;
  
  public MsgRespConsortiaField() {
    super();
    
    this.data = new Field[MsgTypes.MAX_CONSORTIAFIELD];
    for(int idx = 0; idx < MsgTypes.MAX_CONSORTIAFIELD; idx++) {
      this.data[idx] = new Field();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAFIELD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_CONSORTIAFIELD; idx++) {
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
    return 8 + Field.LENGTH * MsgTypes.MAX_CONSORTIAFIELD;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_CONSORTIAFIELD - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
