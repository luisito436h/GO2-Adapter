package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestCommanderPropertyStone extends MsgHead {
  public int guid;
  public int type;
  public int lockFlag;
  public int objStoneId;
  public int srcStoneId1;
  public int srcStoneId2;
  public int srcStoneId3;
  
  public MsgRequestCommanderPropertyStone() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_COMMANDERPROPERTYSTONE;
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
    b.writeInt(this.type);
    b.writeInt(this.lockFlag);
    b.writeInt(this.objStoneId);
    b.writeInt(this.srcStoneId1);
    b.writeInt(this.srcStoneId2);
    b.writeInt(this.srcStoneId3);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 36;
  }
  
  public void release() {
    //do nothing
  }
}
