package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespUnionDoubleSkillCard extends MsgHead {
  public int propsId;
  public int card1;
  public int card2;
  public int goods;
  public int goodsLockFlag;
  public int chip;
  public int chipLockFlag;
  
  public MsgRespUnionDoubleSkillCard() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_UNIONDOUBLESKILLCARD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.propsId = b.readInt();
    this.card1 = b.readInt();
    this.card2 = b.readInt();
    this.goods = b.readInt();
    this.goodsLockFlag = b.readInt();
    this.chip = b.readInt();
    this.chipLockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
