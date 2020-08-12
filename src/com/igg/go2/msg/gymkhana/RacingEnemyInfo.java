package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RacingEnemyInfo {
  public static final short LENGTH = 16 + MsgTypes.MAX_NAME;
  
  public long userId;
  public int rankId;
  public int gameServerId;
  public String name;
  
  public RacingEnemyInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.rankId = b.readInt();
    this.gameServerId = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeLong(this.userId);
    b.writeInt(this.rankId);
    b.writeInt(this.gameServerId);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
