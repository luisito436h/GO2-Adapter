package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespArenaStatus extends MsgHead {
  public int guid;
  public String cName;
  public int roomId;
  public byte request;
  public byte status;
  
  public MsgRespArenaStatus() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ARENA_STATUS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.cName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.roomId = b.readInt();
    this.request = b.readByte();
    this.status = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 14 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
