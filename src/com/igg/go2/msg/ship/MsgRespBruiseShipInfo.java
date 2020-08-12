package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespBruiseShipInfo extends MsgHead {
  public int dataLen;
  public int shipModelId;
  public int num;
  public int needTime;
  public BruiseShipInfo[] deadShipData;
  
  public MsgRespBruiseShipInfo() {
    super();
    
    this.deadShipData = new BruiseShipInfo[MsgTypes.MAX_DEADSHIPDATA];
    for(int idx = 0; idx < MsgTypes.MAX_DEADSHIPDATA; idx++) {
      this.deadShipData[idx] = new BruiseShipInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BRUISESHIPINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    this.shipModelId = b.readInt();
    this.num = b.readInt();
    this.needTime = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_DEADSHIPDATA; idx++) {
      if(b.size() > b.getPosition()) {
        this.deadShipData[idx].readBuf(b);
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
    return 20 + BruiseShipInfo.LENGTH * MsgTypes.MAX_DEADSHIPDATA;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_DEADSHIPDATA - 1; idx >= 0; idx--) {
      this.deadShipData[idx].release();
    }
    this.deadShipData = null;
  }
}
