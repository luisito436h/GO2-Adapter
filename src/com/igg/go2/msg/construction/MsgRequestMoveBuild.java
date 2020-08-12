package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestMoveBuild extends MsgHead {
  public int guid;
  public int indexId;
  public short posX;
  public short posY;
  
  public MsgRequestMoveBuild() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_MOVEBUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.indexId = b.readInt();
    this.posX = b.readShort();
    this.posY = b.readShort();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.indexId);
    b.writeShort(this.posX);
    b.writeShort(this.posY);
    
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
