package com.igg.go2.msg.instance;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespEcTypePass extends MsgHead {
  public int dataLen;
  public int[] data;
  
  public MsgRespEcTypePass() {
    super();
    
    this.data = new int[50];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ECTYPEPASS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 50; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.data[idx] = b.readInt();
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 50; idx++) {
      b.writeInt(this.data[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 208;
  }
  
  public void release() {
    this.data = null;
  }
}
