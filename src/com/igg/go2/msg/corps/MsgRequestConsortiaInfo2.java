package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestConsortiaInfo2 extends MsgHead {
  public int guid;
  public String name;
  
  public MsgRequestConsortiaInfo2() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CONSORTIAINFO2;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
