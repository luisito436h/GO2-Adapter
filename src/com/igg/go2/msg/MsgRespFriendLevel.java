/*
 * Used exclusively for quickly writing new Msg classes.
 * Do not fix errors. Remove before compile.
 */

package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFriendLevel extends MsgHead {
  public int dataLen;
  public long[] data;
  public byte[] dataLevel;
  
  public MsgRespFriendLevel() {
    super();
    
    this.data = new long[MsgTypes.MAX_MSGFRIENDLEN];
    this.dataLevel = new byte[MsgTypes.MAX_MSGFRIENDLEN];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FRIENDLEVEL;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_MSGFRIENDLEN; idx++) {
      if(b.sizeRemaining() >= 8) {
        this.data[idx] = b.readLong();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSGFRIENDLEN; idx++) {
      if(b.sizeRemaining() >= 1) {
        this.data[idx] = b.readByte();
      }
    }
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
    return 8 * MsgTypes.MAX_MSGFRIENDLEN * 9;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
