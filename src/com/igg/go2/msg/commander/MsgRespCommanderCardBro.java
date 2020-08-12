package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCommanderCardBro extends MsgHead {
  public int guid;
  public int srcPropsId;
  public int objPropsId;
  public int cardLevel;
  public String name;
  
  public MsgRespCommanderCardBro() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERCARDBRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.srcPropsId = b.readInt();
    this.objPropsId = b.readInt();
    this.cardLevel = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
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
