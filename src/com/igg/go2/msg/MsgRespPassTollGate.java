package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespPassTollGate extends MsgHead {
  public int tollGate;
  
  public MsgRespPassTollGate() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_PASS_TOLLGATE;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.tollGate = b.readInt();
  }
  @Override
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 8;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
