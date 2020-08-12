package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespBruiseShipRelive extends MsgHead {
  public int errorCode;
  public int type;
  public int shipModelId;
  public int num;
  public int needTime;
  
  public MsgRespBruiseShipRelive() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BRUISESHIPRELIVE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.type = b.readInt();
    this.shipModelId = b.readInt();
    this.num = b.readInt();
    this.needTime = b.readInt();
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
