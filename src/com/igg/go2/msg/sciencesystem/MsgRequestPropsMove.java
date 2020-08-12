package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestPropsMove extends MsgHead {
  public int guid;
  public int type;
  public int propsId;
  public int propsNum;
  public int lockFlag;
  
  public MsgRequestPropsMove() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_PROPSMOVE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.type = b.readInt();
    this.propsId = b.readInt();
    this.propsNum = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.type);
    b.writeInt(this.propsId);
    b.writeInt(this.propsNum);
    b.writeInt(this.lockFlag);
    
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
