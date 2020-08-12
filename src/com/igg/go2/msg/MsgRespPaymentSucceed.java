package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespPaymentSucceed extends MsgHead {
  public int credit;
  
  public MsgRespPaymentSucceed() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_PAYMENTSUCCEED;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.credit = b.readInt();
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
