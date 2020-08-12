package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgClientLoginToG extends MsgHead {
  public long userId;
  public String checkOutText;
  public String sessionKey;
  public String registerName;
  public byte registerFlag;
  
  public MsgClientLoginToG() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_CLIENT_LOGINTOG;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.userId = b.readLong();
    this.checkOutText = b.readString(MsgTypes.VALIDATECODE_LENGTH, ByteArray.CHARSET_UTF8);
    this.sessionKey = b.readString(MsgTypes.SESSIONKEY_LENGTH, ByteArray.CHARSET_UTF8);
    this.registerName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.registerFlag = b.readByte();
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeLong(this.userId);
    b.writeString(this.checkOutText, MsgTypes.VALIDATECODE_LENGTH, ByteArray.CHARSET_UTF8);
    b.writeString(this.sessionKey, MsgTypes.SESSIONKEY_LENGTH, ByteArray.CHARSET_UTF8);
    b.writeString(this.registerName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeByte(this.registerFlag);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 17 + MsgTypes.VALIDATECODE_LENGTH + MsgTypes.SESSIONKEY_LENGTH + MsgTypes.MAX_NAME;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
