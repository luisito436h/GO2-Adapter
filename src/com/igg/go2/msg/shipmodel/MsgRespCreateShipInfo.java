package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCreateShipInfo extends MsgHead {
  public int maxCreateShipNum;
  public short incShipPercent;
  public short dataLen;
  public CreateShipInfo[] data;
  
  public MsgRespCreateShipInfo() {
    super();
    
    this.data = new CreateShipInfo[MsgTypes.MAX_CREATESHIPLIST];
    for(int idx = 0; idx < MsgTypes.MAX_CREATESHIPLIST; idx++) {
      this.data[idx] = new CreateShipInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MAX_CREATESHIPLIST;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.maxCreateShipNum = b.readInt();
    this.incShipPercent = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_CREATESHIPLIST; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.maxCreateShipNum);
    b.writeShort(this.incShipPercent);
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_CREATESHIPLIST; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + CreateShipInfo.LENGTH * MsgTypes.MAX_CREATESHIPLIST;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_CREATESHIPLIST - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
