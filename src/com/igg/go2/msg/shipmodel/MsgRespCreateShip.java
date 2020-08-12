package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCreateShip extends MsgHead {
  public int shipModelId;
  public int needTime;
  public int num;
  public int gas;
  public int metal;
  public int money;
  
  public MsgRespCreateShip() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATESHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipModelId = b.readInt();
    this.needTime = b.readInt();
    this.num = b.readInt();
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.shipModelId);
    b.writeInt(this.needTime);
    b.writeInt(this.num);
    b.writeInt(this.gas);
    b.writeInt(this.metal);
    b.writeInt(this.money);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 28;
  }
  
  public void release() {
    //do nothing
  }
}
