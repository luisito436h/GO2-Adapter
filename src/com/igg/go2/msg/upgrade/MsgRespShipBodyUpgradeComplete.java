package com.igg.go2.msg.upgrade;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespShipBodyUpgradeComplete extends MsgHead {
  public int bodyPartId;
  public byte type;
  
  public MsgRespShipBodyUpgradeComplete() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPBODYUPGRADECOMPLETE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.bodyPartId = b.readInt();
    this.type = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 9;
  }
  
  public void release() {
    //do nothing
  }
}
