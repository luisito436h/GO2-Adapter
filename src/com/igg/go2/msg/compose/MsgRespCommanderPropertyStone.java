package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCommanderPropertyStone extends MsgHead {
  public int type;
  public int lockFlag;
  public int objStoneId;
  public int srcStoneId1;
  public int srcStoneId2;
  public int srcStoneId3;
  public int broFlag;
  public int guid;
  public String name;
  
  public MsgRespCommanderPropertyStone() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERPROPERTYSTONE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.lockFlag = b.readInt();
    this.objStoneId = b.readInt();
    this.srcStoneId1 = b.readInt();
    this.srcStoneId2 = b.readInt();
    this.srcStoneId3 = b.readInt();
    this.broFlag = b.readInt();
    this.guid = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 36 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
