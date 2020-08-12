package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTechUpgradeInfo extends MsgHead {
  public short incTechPercent;
  public short dataLen;
  public TechUpgradeInfo[] data;
  
  public MsgRespTechUpgradeInfo() {
    super();
    
    this.data = new TechUpgradeInfo[20];
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx] = new TechUpgradeInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TECHUPGRADEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.incTechPercent = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < 20; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeShort(this.incTechPercent);
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + TechUpgradeInfo.LENGTH * 20;
  }
  
  public void release() {
    for(int idx = 20 - 1; idx >= 0; idx++) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
