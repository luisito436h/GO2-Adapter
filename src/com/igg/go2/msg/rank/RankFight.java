package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_RANKFIGHT_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RankFight {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME * 2;
  
  public String consortiaName;
  public String userName;
  public long userId;
  public int guid;
  public int galaxyId;
  public int starType;
  public int reserve;
  
  public RankFight() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.guid = b.readInt();
    this.galaxyId = b.readInt();
    this.starType = b.readInt();
    this.reserve = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.consortiaName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.userName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyId);
    b.writeInt(this.starType);
    b.writeInt(this.reserve);
  }
  
  public void release() {
     //do nothing
  }
}
