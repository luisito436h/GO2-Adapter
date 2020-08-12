package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FightRobResource {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME;
  
  public long userId;
  public int headId;
  public int metal;
  public int gas;
  public int money;
  public String roleName;
  
  public FightRobResource() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.headId = b.readInt();
    this.metal = b.readInt();
    this.gas = b.readInt();
    this.money = b.readInt();
    this.roleName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeLong(this.userId);
    b.writeInt(this.headId);
    b.writeInt(this.metal);
    b.writeInt(this.gas);
    b.writeInt(this.money);
    b.writeString(this.roleName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
