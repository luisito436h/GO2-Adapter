package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespRefreshWall extends MsgHead {
  public int type;
  public int propsId;
  public int num;
  
  public MsgRespRefreshWall() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_REFRESHWALL;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.propsId = b.readInt();
    this.num = b.readInt();
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
    return 16;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
