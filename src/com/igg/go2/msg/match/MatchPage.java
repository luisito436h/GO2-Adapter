package com.igg.go2.msg.match;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_MATCHPAGE_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MatchPage {
  public static final short LENGTH = 4 + MsgTypes.MAX_NAME;
  
  public String name;
  public byte matchWin;
  public byte matchLost;
  public byte matchDogfall;
  public byte matchResult;
  
  public MatchPage() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.matchWin = b.readByte();
    this.matchLost = b.readByte();
    this.matchDogfall = b.readByte();
    this.matchResult = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeByte(this.matchWin);
    b.writeByte(this.matchLost);
    b.writeByte(this.matchDogfall);
    b.writeByte(this.matchResult);
  }
  
  public void release() {
     //do nothing
  }
}
