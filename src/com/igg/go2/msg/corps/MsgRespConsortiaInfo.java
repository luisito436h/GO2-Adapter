package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaInfo extends MsgHead {
  public int consortiaCount;
  public short dataLen;
  public short pageId;
  public ConsortiaInfo[] data;
  
  public MsgRespConsortiaInfo() {
    super();
    
    this.data = new ConsortiaInfo[11];
    for(int idx = 0; idx < 11; idx++) {
      this.data[idx] = new ConsortiaInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaCount = b.readInt();
    this.dataLen = b.readShort();
    this.pageId = b.readShort();
    for(int idx = 0; idx < 11 ; idx++) {
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
    return 8 + ConsortiaInfo.LENGTH * 11;
  }
  
  public void release() {
    for(int idx = 11 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
