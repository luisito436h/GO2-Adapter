package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestUpdatePlayerName extends MsgHead {
  public int guid;
  public String name;
  
  public MsgRequestUpdatePlayerName() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_UPDATEPLAYERNAME;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 12 + MsgTypes.MAX_NAME;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
