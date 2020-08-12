package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaAuthUser extends MsgHead {
  public int dataLen;
  public int pageCount;
  public AuthUser[] data;
  
  public MsgRespConsortiaAuthUser() {
    super();
    
    this.data = new AuthUser[7];
    for(int idx = 0; idx < 7; idx++) {
      this.data[idx] = new AuthUser();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAAUTHUSER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    this.pageCount = b.readInt();
    for(int idx = 0; idx < 7; idx++) {
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
    return 12 + AuthUser.LENGTH * 7;
  }
  
  public void release() {
    for(int idx = 7 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
