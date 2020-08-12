package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespTradeGoods extends MsgHead {
  public int errorCode;
  public int id;
  public int num;
  public byte tradeType;
  public byte type;
  public byte priceType;
  public byte timeType;
  public int value;
  
  public MsgRespTradeGoods() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TRADEGOODS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.id = b.readInt();
    this.num = b.readInt();
    this.tradeType = b.readByte();
    this.type = b.readByte();
    this.priceType = b.readByte();
    this.timeType = b.readByte();
    this.value = b.readInt();
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
