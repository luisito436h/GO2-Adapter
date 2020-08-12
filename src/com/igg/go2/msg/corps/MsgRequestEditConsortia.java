package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestEditConsortia extends MsgHead {
  public int guid;
  public String notice;
  public String proclaim;
  public byte headId;
  
  public MsgRequestEditConsortia() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_EDITCONSORTIA;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeString(this.notice, MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    b.writeString(this.proclaim, MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    b.writeByte(this.headId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 13 + MsgTypes.MAX_MEMO * 2;
  }
  
  public void release() {
    //do nothing
  }
}
