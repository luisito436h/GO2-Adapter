package com.igg.go2.msg.reward;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespGetOnlineAward extends MsgHead {
  public int errorCode;
  public int propsId;
  public int propsNum;
  
  public MsgRespGetOnlineAward() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GETONLINEAWARD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.propsId = b.readInt();
    this.propsNum = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16;
  }
  
  public void release() {
    //do nothing
  }
}
