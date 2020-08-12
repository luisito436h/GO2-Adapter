package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FightTotalKill {
  public static final short LENGTH = 16 + MsgTypes.MAX_NAME * 2;
  
  public long userId;
  public int num;
  public short bodyId;
  public short reserve;
  public String modelName;
  public String roleName;
  
  public FightTotalKill() {
    super();
    this.userId = -1;
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.num = b.readInt();
    this.bodyId = b.readShort();
    this.reserve = b.readShort();
    this.modelName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.roleName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeLong(this.userId);
    b.writeInt(this.num);
    b.writeShort(this.bodyId);
    b.writeShort(this.reserve);
    b.writeString(this.modelName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.roleName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
