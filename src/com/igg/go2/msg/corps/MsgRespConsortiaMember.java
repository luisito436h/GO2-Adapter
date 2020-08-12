package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaMember extends MsgHead {
  public int dataLen;
  public Member[] data;
  
  public MsgRespConsortiaMember() {
    super();
    
    this.data = new Member[18];
    for(int idx = 0; idx < 18; idx++) {
      this.data[idx] = new Member();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAMEMBER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 18; idx++) {
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
    return 8 + Member.LENGTH * 18;
  }
  
  public void release() {
    for(int idx = 18 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
