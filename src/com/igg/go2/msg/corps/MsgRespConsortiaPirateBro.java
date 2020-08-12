package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespConsortiaPirateBro extends MsgHead {
  public int flag;
  public int galaxyId;
  public int pirateLevelId;
  public int consortiaId;
  public String consortiaName;
  
  public MsgRespConsortiaPirateBro() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAPIRATEBRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.flag = b.readInt();
    this.galaxyId = b.readInt();
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
    return 20 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
