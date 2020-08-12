package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespDuplicateBulletin extends MsgHead {
  public byte duplicateType;
  public byte bulletinType;
  public short countdown;
  
  public MsgRespDuplicateBulletin() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_DUPLICATE_BULLETIN;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.duplicateType = b.readByte();
    this.bulletinType = b.readByte();
    this.countdown = b.readShort();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8;
  }
  
  public void release() {
    //do nothing
  }
}
