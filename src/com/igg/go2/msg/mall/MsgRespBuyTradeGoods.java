package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespBuyTradeGoods extends MsgHead {
  public int errorCode;
  public int sellGuid;
  public int indexId;
  public int priceType;
  public int price;
  
  public MsgRespBuyTradeGoods() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BUYTRADEGOODS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.sellGuid = b.readInt();
    this.indexId = b.readInt();
    this.priceType = b.readInt();
    this.price = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24;
  }
  
  public void release() {
    //do nothing
  }
}
