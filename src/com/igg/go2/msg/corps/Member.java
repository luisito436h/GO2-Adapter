package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAMEMBER_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class Member {
  public static final short LENGTH = MsgTypes.MAX_NAME + 24;
  
  public String name;
  public long userId;
  public int offlineTime;
  public int throwValue;
  public int guid;
  public byte level;
  public byte status;
  public byte job;
  public byte reserve;
  
  public Member() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.offlineTime = b.readInt();
    this.throwValue = b.readInt();
    this.guid = b.readInt();
    this.level = b.readByte();
    this.status = b.readByte();
    this.job = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
     //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
