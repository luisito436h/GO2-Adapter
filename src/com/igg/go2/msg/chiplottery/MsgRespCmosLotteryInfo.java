package com.igg.go2.msg.chiplottery;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCmosLotteryInfo extends MsgHead {
  public int pirateMoney;
  public byte lotteryPhase;
  public byte usCmosPackCount;
  public short dataLen;
  public CmosInfo[] data;
  
  public MsgRespCmosLotteryInfo() {
    super();
    
    this.data = new CmosInfo[MsgTypes.MAX_CMOSCOUNT];
    for(int idx = 0; idx < MsgTypes.MAX_CMOSCOUNT; idx++) {
      this.data[idx] = new CmosInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CMOSLOTTERYINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.pirateMoney = b.readInt();
    this.lotteryPhase = b.readByte();
    this.usCmosPackCount = b.readByte();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_CMOSCOUNT; idx++) {
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
    /*
     * Not technically how getLength is implemented in source but is faster, saner, and gives the same result.
    */
    return 12 + CmosInfo.LENGTH * MsgTypes.MAX_CMOSCOUNT;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_CMOSCOUNT - 1; idx >= 0; idx--) {
     this.data[idx].release();
    }
    this.data = null;
  }
}
