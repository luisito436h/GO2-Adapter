package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestTradeGoods extends MsgHead {
  public int guid;
  public int id;
  public int num;
  public int price;
  public byte tradeType;
  public byte priceType;
  public byte timeType;
  public byte type;
  
  public MsgRequestTradeGoods() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_TRADEGOODS;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.id);
    b.writeInt(this.num);
    b.writeInt(this.price);
    b.writeByte(this.tradeType);
    b.writeByte(this.priceType);
    b.writeByte(this.timeType);
    b.writeByte(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 28;
  }
  
  public void release() {
    //do nothing
  }
}
