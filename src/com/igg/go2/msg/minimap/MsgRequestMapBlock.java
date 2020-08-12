package com.igg.go2.msg.minimap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestMapBlock extends MsgHead {
  public int guid;
  public int galaxyMapId;
  public int blockId;
  
  public MsgRequestMapBlock() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_MAPBLOCK;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.galaxyMapId = b.readInt();
    this.blockId = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.blockId);
    
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
