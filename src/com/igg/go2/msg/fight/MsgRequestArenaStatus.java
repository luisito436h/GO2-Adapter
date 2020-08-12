package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestArenaStatus extends MsgHead {
  public int guid;
  public int roomId;
  public byte request;
  
  public MsgRequestArenaStatus() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_ARENA_STATUS;
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
    b.writeInt(this.roomId);
    b.writeByte(this.request);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 17;
  }
  
  public void release() {
    //do nothing
  }
}
