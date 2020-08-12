package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespConsortiaPirateChoose extends MsgHead {
  public int errorCode;
  public int objGuid;
  public String objName;
  public int galaxyId;
  public int assault;
  public int levelId;
  
  public MsgRespConsortiaPirateChoose() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAPIRATECHOOSE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.errorCode = b.readInt();
    this.objGuid = b.readInt();
    this.objName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.galaxyId = b.readInt();
    this.assault = b.readInt();
    this.levelId = b.readInt();
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
