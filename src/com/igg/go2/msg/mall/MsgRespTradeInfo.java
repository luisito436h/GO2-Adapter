package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTradeInfo extends MsgHead {
  public int tradeCount;
  public int dataLen;
  public int reserve;
  public TradeInfo[] data;
  
  public MsgRespTradeInfo() {
    super();
    
    this.data = new TradeInfo[5];
    for(int idx = 0; idx < 5; idx++) {
      this.data[idx] = new TradeInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TRADEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.tradeCount = b.readInt();
    this.dataLen = b.readInt();
    this.reserve = b.readInt();
    for(int idx = 0; idx < 5; idx++) {
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
    return 16 + TradeInfo.LENGTH * 5;
  }
  
  public void release() {
    for(int idx = 5 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
