package com.igg.go2.msg.friend;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFriendList extends MsgHead {
  public byte dataLen;
  public byte type;
  public short friendCount;
  public FriendChatUserInfo[] data;
  
  public MsgRespFriendList() {
    super();
    
    this.data = new FriendChatUserInfo[9];
    for(int idx = 0; idx < 9; idx++) {
      this.data[idx] = new FriendChatUserInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FRIENDLIST;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readByte();
    this.type = b.readByte();
    this.friendCount = b.readShort();
    for(int idx = 0; idx < 9; idx++) {
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
    return 8 + FriendChatUserInfo.LENGTH * 9;
  }
  
  public void release() {
    for(int idx = 9 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
