package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FightTotalExp {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME * 2;
  
  public long userId;
  public long commanderUserId;
  public int exp;
  public short headId;
  public short levelId;
  public String commanderName;
  public String roleName;
  
  public FightTotalExp() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.commanderUserId = b.readLong();
    this.exp = b.readInt();
    this.headId = b.readShort();
    this.levelId = b.readShort();
    this.commanderName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.roleName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeLong(this.userId);
    b.writeLong(this.commanderUserId);
    b.writeInt(this.exp);
    b.writeShort(this.headId);
    b.writeShort(this.levelId);
    b.writeString(this.commanderName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.roleName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
