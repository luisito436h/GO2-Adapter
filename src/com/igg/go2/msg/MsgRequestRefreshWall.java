package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestRefreshWall extends MsgHead {
  public int guid;
  public int type;
  
  public MsgRequestRefreshWall() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_REFRESHWALL;
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
    b.writeInt(this.type);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 16;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
