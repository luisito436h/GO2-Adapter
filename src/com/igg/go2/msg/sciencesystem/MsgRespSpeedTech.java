package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespSpeedTech extends MsgHead {
  public int techId;
  public int techSpeedId;
  public int time;
  public int credit;
  
  public MsgRespSpeedTech() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SPEEDTECH;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.techId = b.readInt();
    this.techSpeedId = b.readInt();
    this.time = b.readInt();
    this.credit = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.techId);
    b.writeInt(this.techSpeedId);
    b.writeInt(this.time);
    b.writeInt(this.credit);
    
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
