package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespMoveBuild extends MsgHead {
  public int indexId;
  public short posX;
  public short posY;
  
  public MsgRespMoveBuild() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MOVEBUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.indexId = b.readInt();
    this.posX = b.readShort();
    this.posY = b.readShort();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.indexId);
    b.writeShort(this.posX);
    b.writeShort(this.posY);
    
    b.padSize(super.usSize);
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
