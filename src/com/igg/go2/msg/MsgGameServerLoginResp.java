package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgGameServerLoginResp extends MsgHead {
  public int guid;
  public int hdFlag;
  
  public MsgGameServerLoginResp() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_GAMESERVER_LOGINRESP;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.hdFlag = b.readInt();
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
    return 12;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
