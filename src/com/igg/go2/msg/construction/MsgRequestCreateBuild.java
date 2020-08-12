package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCreateBuild extends MsgHead {
  public int guid;
  public int buildingId;
  public int indexId;
  public short posX;
  public short posY;
  
  public MsgRequestCreateBuild() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATEBUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.buildingId = b.readInt();
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
    b.writeInt(this.buildingId);
    b.writeInt(this.indexId);
    b.writeShort(this.posX);
    b.writeShort(this.posY);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24;
  }
  
  public void release() {
    //do nothing
  }
}
