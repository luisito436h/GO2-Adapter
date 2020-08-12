package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestRacingBattle extends MsgHead {
  public long userId;
  public long objUserId;
  public int guid;
  
  public MsgRequestRacingBattle() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_RACINGBATTLE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.userId = b.readLong();
    this.objUserId = b.readLong();
    this.guid = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeLong(this.userId);
    b.writeLong(this.objUserId);
    b.writeInt(this.guid);
    
    b.padSize(super.usSize);
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
