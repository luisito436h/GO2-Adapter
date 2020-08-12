package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespUnionCommanderCardBro extends MsgHead {
  public int guid;
  public long userId;
  public String name;
  public int skillId;
  public int cardLevel;
  public int successFlag;
  
  public MsgRespUnionCommanderCardBro() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_UNIONCOMMANDERCARDBRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.skillId = b.readInt();
    this.cardLevel = b.readInt();
    this.successFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 28 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
