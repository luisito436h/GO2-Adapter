package com.igg.go2.msg.minimap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaStar extends MsgHead {
  public short galaxyMapId;
  public short dataLen;
  public int[] data;
  
  public MsgRespConsortiaStar() {
    super();
    
    this.data = new int[250];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIASTAR;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < 250; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.data[idx] = b.readInt();
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeShort(this.galaxyMapId);
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < 250; idx++) {
      b.writeInt(this.data[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 1008;
  }
  
  public void release() {
    this.data = null;
  }
}
