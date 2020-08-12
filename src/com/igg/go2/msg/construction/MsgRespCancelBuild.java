package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCancelBuild extends MsgHead {
  public int indexId;
  public int gas;
  public int metal;
  public int money;
  public byte status;
  
  public MsgRespCancelBuild() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CANCELBUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.indexId = b.readInt();
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
    this.status = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.indexId);
    b.writeInt(this.gas);
    b.writeInt(this.metal);
    b.writeInt(this.money);
    b.writeByte(this.status);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 21;
  }
  
  public void release() {
    //do nothing
  }
}
