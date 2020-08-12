package com.igg.go2.msg.upgrade;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespShipBodyUpgrade extends MsgHead {
  public int bodyPartId;
  public int needTime;
  public byte type;
  public byte cancelFlag;
  public short reserve;
  public int money;
  public int metal;
  public int gas;
  
  public MsgRespShipBodyUpgrade() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPBODYUPGRADE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.bodyPartId = b.readInt();
    this.needTime = b.readInt();
    this.type = b.readByte();
    this.cancelFlag = b.readByte();
    this.reserve = b.readShort();
    this.money = b.readInt();
    this.metal = b.readInt();
    this.gas = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
