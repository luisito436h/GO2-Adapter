package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestCreateConsortia extends MsgHead {
  public int guid;
  public String name;
  public String proclaim;
  public byte headId;
  
  public MsgRequestCreateConsortia() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATECONSORTIA;
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
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.proclaim, MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    b.writeByte(this.headId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 13 + MsgTypes.MAX_NAME + MsgTypes.MAX_MEMO;
  }
  
  public void release() {
    //do nothing
  }
}
