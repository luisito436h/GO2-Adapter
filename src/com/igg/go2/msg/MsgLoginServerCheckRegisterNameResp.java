package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgLoginServerCheckRegisterNameResp extends MsgHead {
  public int socketAutoId;
  public long userId;
  public int gameServerId;
  public int errorCode;
  
  public MsgLoginServerCheckRegisterNameResp() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_LOGINSERVER_CHECKREGISTERNAMERESP;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.socketAutoId = b.readInt();
    this.userId = b.readLong();
    this.gameServerId = b.readInt();
    this.errorCode = b.readInt();
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.socketAutoId);
    b.writeLong(this.userId);
    b.writeInt(this.gameServerId);
    b.writeInt(this.errorCode);
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 24;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
