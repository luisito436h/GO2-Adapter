package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespDuplicateBattle extends MsgHead {
  
  public MsgRespDuplicateBattle() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_DUPLICATE_BATTLE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 4;
  }
  
  public void release() {
    //do nothing
  }
}
