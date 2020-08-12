package com.igg.go2.msg.friend;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FriendChatUserInfo {
  public static final short LENGTH = 16 + MsgTypes.MAX_NAME;
  
  public String name;
  public long userId;
  public int guid;
  public byte status;
  public byte level;
  public byte headId;
  public byte reserve;
  
  public FriendChatUserInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.guid = b.readInt();
    this.status = b.readByte();
    this.level = b.readByte();
    this.headId = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.guid);
    b.writeByte(this.status);
    b.writeByte(this.level);
    b.writeByte(this.headId);
    b.writeByte(this.reserve);
  }
  
  public void release() {
     //do nothing
  }
}
