package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespPropsMove extends MsgHead {
  public int type;
  public int propsId;
  public int propsNum;
  public int lockFlag;
  
  public MsgRespPropsMove() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_PROPSMOVE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.propsId = b.readInt();
    this.propsNum = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
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
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
