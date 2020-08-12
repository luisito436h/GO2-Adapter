package com.igg.go2.msg.chat;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestUserInfo extends MsgHead {
  public int guid;
  public int objGuid;
  public int objGalaxyId;
  public int reserve;
  public long userId;
  public String userName;
  
  public MsgRequestUserInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_USERINFO;
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
    b.writeInt(this.objGuid);
    b.writeInt(this.objGalaxyId);
    b.writeInt(this.reserve);
    b.writeLong(this.userId);
    b.writeString(this.userName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
