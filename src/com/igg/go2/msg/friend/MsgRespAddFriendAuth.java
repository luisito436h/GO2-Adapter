package com.igg.go2.msg.friend;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespAddFriendAuth extends MsgHead {
  public int srcGuid;
  public long srcUserId;
  public String srcName;
  
  public MsgRespAddFriendAuth() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ADDFRIENDAUTH;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.srcGuid = b.readInt();
    this.srcUserId = b.readLong();
    this.srcName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
