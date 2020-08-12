package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespInsertFlagBro extends MsgHead {
  public int type;
  public int galaxyMapId;
  public int galaxyId;
  
  public MsgRespInsertFlagBro() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_INSERTFLAGBRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.type);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16;
  }
  
  public void release() {
    //do nothing
  }
}
