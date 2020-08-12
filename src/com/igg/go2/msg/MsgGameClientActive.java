package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgGameClientActive extends MsgHead {
  public int guid;
  
  public MsgGameClientActive() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_GAME_CLIENTACTIVE;
  }
  @Override
  public void readBuf(ByteArray b) {
    //do nothing
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 12;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
