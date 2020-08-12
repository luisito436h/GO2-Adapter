package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgClientLoginToL extends MsgHead {
  public long userId;
  public String sessionKey;
  public int gameServerId;
  public int registerFlag;
  public String registerName;
  
  public MsgClientLoginToL() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_CLIENT_LOGINTOL;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.userId = b.readLong();
    this.sessionKey = b.readString(128, ByteArray.CHARSET_UTF8);
    this.gameServerId = b.readInt();
    this.registerFlag = b.readInt();
    this.registerName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeLong(this.userId);
    b.writeString(this.sessionKey, 128, ByteArray.CHARSET_UTF8);
    b.writeInt(this.gameServerId);
    b.writeInt(this.registerFlag);
    b.writeString(this.registerName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 152 + MsgTypes.MAX_NAME;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
