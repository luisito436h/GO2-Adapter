package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespThieveFieldResource extends MsgHead {
  public int errorCode;
  public int galaxyId;
  public int gas;
  public int metal;
  public int money;
  
  public MsgRespThieveFieldResource() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_THIEVEFIELDRESOURCE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.galaxyId = b.readInt();
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24;
  }
  
  public void release() {
    //do nothing
  }
}
