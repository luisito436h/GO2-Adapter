package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespWarFieldStatus extends MsgHead {
  public int warfield;
  public short userNumber;
  public byte status;
  public byte matchLevel;
  
  public MsgRespWarFieldStatus() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_WARFIELD_STATUS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.warfield = b.readInt();
    this.userNumber = b.readShort();
    this.status = b.readByte();
    this.matchLevel = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12;
  }
  
  public void release() {
    //do nothing
  }
}
