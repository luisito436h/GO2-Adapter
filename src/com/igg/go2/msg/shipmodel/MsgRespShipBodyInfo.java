package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespShipBodyInfo extends MsgHead {
  public short bodyNum;
  public short partNum;
  public short[] bodyId;
  public short[] partId;
  
  public MsgRespShipBodyInfo() {
    super();
    
    this.bodyId = new short[200];
    this.partId = new short[300];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPMODELINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.bodyNum = b.readShort();
    this.partNum = b.readShort();
    for(int idx = 0; idx < 200; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.bodyId[idx] = b.readShort();
      }
    }
    for(int idx = 0; idx < 300; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.partId[idx] = b.readShort();
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
    return 1008;
  }
  
  public void release() {
    this.bodyId = null;
    this.partId = null;
  }
}
