package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespEcTypeState extends MsgHead {
  public short ectypeId;
  public byte gateId;
  public byte state;
  
  public MsgRespEcTypeState() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ECTYPESTATE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.ectypeId = b.readShort();
    this.gateId = b.readByte();
    this.state = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeShort(this.ectypeId);
    b.writeByte(this.gateId);
    b.writeByte(this.state);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8;
  }
  
  public void release() {
    //do nothing
  }
}
