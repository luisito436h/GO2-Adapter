package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgFightGalaxyBegin extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int type;
  public int pirateLevelId;
  public int consortiaId;
  public String consortiaName;
  
  public MsgFightGalaxyBegin() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_FIGHTGALAXYBEGIN;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.type = b.readInt();
    this.pirateLevelId = b.readInt();
    this.consortiaId = b.readInt();
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
