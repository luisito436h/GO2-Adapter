package com.igg.go2.msg.destructionship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespDestroyShip extends MsgHead {
  public int gas;
  public int metal;
  public int money;
  
  public MsgRespDestroyShip() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_DESTROYSHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.gas);
    b.writeInt(this.metal);
    b.writeInt(this.money);
    
    b.padSize(super.usSize);
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
