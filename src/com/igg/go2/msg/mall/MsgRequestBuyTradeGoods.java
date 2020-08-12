package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestBuyTradeGoods extends MsgHead {
  public int guid;
  public int sellGuid;
  public int indexId;
  
  public MsgRequestBuyTradeGoods() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_BUYTRADEGOODS;
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
    b.writeInt(this.sellGuid);
    b.writeInt(this.indexId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
