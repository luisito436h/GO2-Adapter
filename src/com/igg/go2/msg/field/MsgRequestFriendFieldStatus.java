package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestFriendFieldStatus extends MsgHead {
  public int guid;
  public short type;
  public short dataLen;
  public long[] data;
  
  public MsgRequestFriendFieldStatus() {
    super();
    
    this.data = new long[MsgTypes.MAX_FRIENDFIELDSTATUS];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_FRIENDFIELDSTATUS;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeShort(this.type);
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_FRIENDFIELDSTATUS; idx++) {
      b.writeLong(this.data[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_FRIENDFIELDSTATUS * 8;
  }
  
  public void release() {
    this.data = null;
  }
}
