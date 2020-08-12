package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIATHROWRANK_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ThrowRank {
  public static final short LENGTH = MsgTypes.MAX_NAME + 24;
  
  public String name;
  public long userId;
  public int throwRes;
  public int throwCredit;
  public int guid;
  public int rankId;
  
  public ThrowRank() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.throwRes = b.readInt();
    this.throwCredit = b.readInt();
    this.guid = b.readInt();
    this.rankId = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
