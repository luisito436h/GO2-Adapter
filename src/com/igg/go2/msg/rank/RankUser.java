package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RANKUSERINFO</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RankUser {
  public static final short LENGTH = 32 + MsgTypes.MAX_NAME * 2;
  
  public String name;
  public String consortiaName;
  public long userId;
  public int assault;
  public int rankId;
  public int killTotal;
  public int guid;
  public int consortiaId;
  public short headId;
  public byte level;
  public byte reserve;
  
  public RankUser() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.assault = b.readInt();
    this.rankId = b.readInt();
    this.killTotal = b.readInt();
    this.guid = b.readInt();
    this.consortiaId = b.readInt();
    this.headId = b.readShort();
    this.level = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.consortiaName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.assault);
    b.writeInt(this.rankId);
    b.writeInt(this.killTotal);
    b.writeInt(this.guid);
    b.writeInt(this.consortiaId);
    b.writeShort(this.headId);
    b.writeByte(this.level);
    b.writeByte(this.reserve);
  }
  
  public void release() {
     //do nothing
  }
}
