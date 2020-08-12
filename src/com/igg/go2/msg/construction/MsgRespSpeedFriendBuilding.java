package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespSpeedFriendBuilding extends MsgHead {
  public int errorCode;
  public int indexId;
  public int type;
  public int spareTime;
  
  public MsgRespSpeedFriendBuilding() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SPEEDFRIENDBUILDING;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.indexId = b.readInt();
    this.type = b.readInt();
    this.spareTime = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.errorCode);
    b.writeInt(this.indexId);
    b.writeInt(this.type);
    b.writeInt(this.spareTime);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
