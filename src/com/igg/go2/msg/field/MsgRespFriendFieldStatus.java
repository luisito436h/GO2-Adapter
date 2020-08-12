package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFriendFieldStatus extends MsgHead {
  public short type;
  public short dataLen;
  public FriendFieldStatus[] data;
  
  public MsgRespFriendFieldStatus() {
    super();
    
    this.data = new FriendFieldStatus[MsgTypes.MAX_FRIENDFIELDSTATUS];
    for(int idx = 0; idx < MsgTypes.MAX_FRIENDFIELDSTATUS; idx++) {
      this.data[idx] = new FriendFieldStatus();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FRIENDFIELDSTATUS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_FRIENDFIELDSTATUS; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + FriendFieldStatus.LENGTH * MsgTypes.MAX_FRIENDFIELDSTATUS;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_FRIENDFIELDSTATUS - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
