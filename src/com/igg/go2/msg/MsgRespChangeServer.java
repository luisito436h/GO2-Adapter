package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespChangeServer extends MsgHead {
  public int guid;
  public byte gameServerId;
  public byte errorCode;
  
  public MsgRespChangeServer() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CHANGESERVER;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.gameServerId = b.readByte();
    this.errorCode = b.readByte();
  }
  @Override
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 10;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
