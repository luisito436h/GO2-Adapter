package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespExchangeRes extends MsgHead {
  public int metal;
  public int gas;
  
  public MsgRespExchangeRes() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_EXCHANGERES;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.metal = b.readInt();
    this.gas = b.readInt();
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.metal);
    b.writeInt(this.gas);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 12;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
