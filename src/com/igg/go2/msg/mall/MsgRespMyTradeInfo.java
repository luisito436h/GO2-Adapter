package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespMyTradeInfo extends MsgHead {
  public int dataLen;
  public TradeInfo[] data;
  
  public MsgRespMyTradeInfo() {
    super();
    
    this.data = new TradeInfo[MsgTypes.MAX_TRADECOUNT];
    for(int idx = 0; idx < MsgTypes.MAX_TRADECOUNT; idx++) {
      this.data[idx] = new TradeInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MYTRADEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_TRADECOUNT; idx++) {
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
    return 8 + MsgTypes.MAX_TRADECOUNT * TradeInfo.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_TRADECOUNT - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
