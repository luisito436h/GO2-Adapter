package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgFightGalaxyOver extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int consortiaId;
  public String consortiaName;
  
  public MsgFightGalaxyOver() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_FIGHTGALAXYOVER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.consortiaId = b.readInt();
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.consortiaId);
    b.writeString(this.consortiaName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
