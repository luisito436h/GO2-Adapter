package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespDealConsortiaAuthUser extends MsgHead {
  public int errorCode;
  public int agree;
  
  public MsgRespDealConsortiaAuthUser() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_DEALCONSORTIAAUTHUSER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.agree = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12;
  }
  
  public void release() {
    //do nothing
  }
}
