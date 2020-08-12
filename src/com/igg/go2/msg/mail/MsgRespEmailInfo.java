package com.igg.go2.msg.mail;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespEmailInfo extends MsgHead {
  public short dataLen;
  public short emailCount;
  public EmailInfo[] data;
  
  public MsgRespEmailInfo() {
    super();
    
    this.data = new EmailInfo[9];
    for(int idx = 0; idx < 9; idx++) {
      this.data[idx] = new EmailInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_EMAILINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readShort();
    this.emailCount = b.readShort();
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
    return 8 + EmailInfo.LENGTH * 9;
  }
  
  public void release() {
    for(int idx = 9 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
