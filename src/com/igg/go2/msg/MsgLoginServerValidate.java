package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgLoginServerValidate extends MsgHead {
  public int port;
  public long userId;
  public String ip;
  public String checkOutText;
  
  public MsgLoginServerValidate() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_LOGINSERVER_VALIDATE;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.port = b.readInt();
    this.userId = b.readLong();
    this.ip = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.checkOutText = b.readString(MsgTypes.VALIDATECODE_LENGTH, ByteArray.CHARSET_UTF8);
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.port);
    b.writeLong(this.userId);
    b.writeString(this.ip, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.checkOutText, MsgTypes.VALIDATECODE_LENGTH, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 73;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
