package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestEcType extends MsgHead {
  public int guid;
  public short ecTypeId;
  public byte gateId;
  public byte dataLen;
  public int[] shipTeamId;
  public int passKey;
  public int roomId;
  public byte joinFlag;
  public byte activity;
  public short propsId;
  public byte capturePlace;
  public byte reserve;
  
  public MsgRequestEcType() {
    super();
    
    this.shipTeamId = new int[MsgTypes.MAX_USERSHIPTEAMNUM];
    this.passKey = -1;
    this.roomId = -1;
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_ECTYPE;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeShort(this.ecTypeId);
    b.writeByte(this.gateId);
    b.writeByte(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_USERSHIPTEAMNUM; idx++) {
      b.writeInt(this.shipTeamId[idx]);
    }
    b.writeInt(this.passKey);
    b.writeInt(this.roomId);
    b.writeByte(this.joinFlag);
    b.writeByte(this.activity);
    b.writeShort(this.propsId);
    b.writeByte(this.capturePlace);
    b.writeByte(this.reserve);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 30 + MsgTypes.MAX_USERSHIPTEAMNUM * 4;
  }
  
  public void release() {
    //do nothing
  }
}
