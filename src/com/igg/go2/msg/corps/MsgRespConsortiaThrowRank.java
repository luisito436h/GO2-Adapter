package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaThrowRank extends MsgHead {
  public int throwValue;
  public int myWealth;
  public short memberCount;
  public short dataLen;
  public ThrowRank[] data;
  
  public MsgRespConsortiaThrowRank() {
    super();
    
    this.data = new ThrowRank[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new ThrowRank();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIATHROWRANK;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.throwValue = b.readInt();
    this.myWealth = b.readInt();
    this.memberCount = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < 10; idx++) {
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
    return 16 + ThrowRank.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 10 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
