package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestFriendLevel extends MsgHead {
  public int guid;
  public int dataLen;
  public long[] data;
  
  public MsgRequestFriendLevel() {
    super();
    
    this.data = new long[MsgTypes.MAX_MSGFRIENDLEN];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_FRIENDLEVEL;
  }
  @Override
  public void readBuf(ByteArray b) {
    //do nothing
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_MSGFRIENDLEN; idx++) {
      b.writeLong(this.data[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_MSGFRIENDLEN * 8;
  }
  
  @Override
  public void release() {
    this.data = null;
  }
}
