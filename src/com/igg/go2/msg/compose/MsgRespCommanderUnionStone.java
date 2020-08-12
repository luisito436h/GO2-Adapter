package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCommanderUnionStone extends MsgHead {
  public int propsId;
  public int lockFlag;
  public int broFlag;
  public int guid;
  public String name;
  
  public MsgRespCommanderUnionStone() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERUNIONSTONE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.propsId = b.readInt();
    this.lockFlag = b.readInt();
    this.broFlag = b.readInt();
    this.guid = b.readInt();
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
