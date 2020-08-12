package com.igg.go2.msg.mail;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestEmailInfo extends MsgHead {
  public int guid;
  public int pageId;
  public byte type;
  public byte readFlag;
  
  public MsgRequestEmailInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_EMAILINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.pageId = b.readInt();
    this.type = b.readByte();
    this.readFlag = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.pageId);
    b.writeByte(this.type);
    b.writeByte(this.readFlag);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 18;
  }
  
  public void release() {
    //do nothing
  }
}
