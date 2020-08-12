package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestUnionCommanderCard extends MsgHead {
  public int guid;
  public int card1;
  public int card2;
  public int card3;
  public int goods;
  public int goodsLockFlag;
  
  public MsgRequestUnionCommanderCard() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_UNIONCOMMANDERCARD;
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
    b.writeInt(this.card1);
    b.writeInt(this.card2);
    b.writeInt(this.card3);
    b.writeInt(this.goods);
    b.writeInt(this.goodsLockFlag);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32;
  }
  
  public void release() {
    //do nothing
  }
}
