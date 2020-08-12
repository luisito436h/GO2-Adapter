package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespBuyGoods extends MsgHead {
  public int propsId;
  public int price;
  public int num;
  public byte lockFlag;
  public byte type;
  
  public MsgRespBuyGoods() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BUYGOODS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.propsId = b.readInt();
    this.price = b.readInt();
    this.num = b.readInt();
    this.lockFlag = b.readByte();
    this.type = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
