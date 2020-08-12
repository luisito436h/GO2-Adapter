package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespBuildInfoFriend extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int storageFlagMetal;
  public int storageFlagGas;
  public int storageFlagMoney;
  public int shipFactoryFlag;
  
  public MsgRespBuildInfoFriend() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BUILDINFOFRIEND;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.storageFlagMetal = b.readInt();
    this.storageFlagGas = b.readInt();
    this.storageFlagMoney = b.readInt();
    this.shipFactoryFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.storageFlagMetal);
    b.writeInt(this.storageFlagGas);
    b.writeInt(this.storageFlagMoney);
    b.writeInt(this.shipFactoryFlag);
    
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
