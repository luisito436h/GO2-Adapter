package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTechInfo extends MsgHead {
  public int dataLen;
  public TechInfo[] data;
  
  public MsgRespTechInfo() {
    super();
    
    this.data = new TechInfo[250];
    for(int idx = 0; idx < 250; idx++) {
      this.data[idx] = new TechInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TECHINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 250; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 250; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + TechInfo.LENGTH * 250;
  }
  
  public void release() {
    //do nothing
  }
}
