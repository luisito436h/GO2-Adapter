package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespShipModelInfo extends MsgHead {
  public short dataLen;
  public ShipModelInfo[] data;
  
  public MsgRespShipModelInfo() {
    super();
    
    this.data = new ShipModelInfo[7];
    for(int idx = 0; idx < 7; idx++) {
      this.data[idx] = new ShipModelInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPMODELINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readShort();
    for(int idx = 0; idx < 7; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < 7; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 6 + ShipModelInfo.LENGTH * 7;
  }
  
  public void release() {
    for(int idx = 7 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
