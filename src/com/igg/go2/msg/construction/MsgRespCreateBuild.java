package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCreateBuild extends MsgHead {
  public int buildingId;
  public int levelId;
  public int indexId;
  public int needTime;
  public int gas;
  public int metal;
  public int money;
  
  public MsgRespCreateBuild() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATEBUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.buildingId = b.readInt();
    this.levelId = b.readInt();
    this.indexId = b.readInt();
    this.needTime = b.readInt();
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.buildingId);
    b.writeInt(this.levelId);
    b.writeInt(this.needTime);
    b.writeInt(this.gas);
    b.writeInt(this.metal);
    b.writeInt(this.money);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32;
  }
  
  public void release() {
    //do nothing
  }
}
