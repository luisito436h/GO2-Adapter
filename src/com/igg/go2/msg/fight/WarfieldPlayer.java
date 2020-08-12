package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_WARFIELD_PLAYERLIST_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class WarfieldPlayer {
  public static final short LENGTH = 12 + MsgTypes.MAX_NAME;
  
  public long userId;
  public int guid;
  public String name;
  
  public WarfieldPlayer() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.guid = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeLong(this.userId);
    b.writeInt(this.guid);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
