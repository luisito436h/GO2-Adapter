package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_RACINGRANK_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RacingRank {
  public static final short LENGTH = 16 + MsgTypes.MAX_NAME;
  
  public String name;
  public long userId;
  public int gameServerId;
  public int rankId;
  
  public RacingRank() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.gameServerId = b.readInt();
    this.rankId = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.gameServerId);
    b.writeInt(this.rankId);
  }
  
  public void release() {
     //do nothing
  }
}
