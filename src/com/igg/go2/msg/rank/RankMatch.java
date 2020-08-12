package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_RANKMATCH_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RankMatch {
  public static final short LENGTH = 12 + MsgTypes.MAX_NAME;
  
  public String userName;
  public int guid;
  public int matchWeekTop;
  public byte matchLevel;
  public byte matchWin;
  public byte matchLost;
  public byte matchDogfall;
  
  public RankMatch() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.guid = b.readInt();
    this.matchWeekTop = b.readInt();
    this.matchLevel = b.readByte();
    this.matchWin = b.readByte();
    this.matchLost = b.readByte();
    this.matchDogfall = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.userName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.guid);
    b.writeInt(this.matchWeekTop);
    b.writeByte(this.matchLevel);
    b.writeByte(this.matchWin);
    b.writeByte(this.matchLost);
    b.writeByte(this.matchDogfall);
  }
  
  public void release() {
     //do nothing
  }
}
