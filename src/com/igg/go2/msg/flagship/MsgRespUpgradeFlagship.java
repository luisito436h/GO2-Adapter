package com.igg.go2.msg.flagship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespUpgradeFlagship extends MsgHead {
  public int shipBodyId;
  
  public MsgRespUpgradeFlagship() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_UPGRADEFLAGSHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipBodyId = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8;
  }
  
  public void release() {
    //do nothing
  }
}
