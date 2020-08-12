package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAEVENT_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class Event {
  public static final short LENGTH = MsgTypes.MAX_NAME * 2 + 32;
  
  public String srcName;
  public String objName;
  public long srcUserId;
  public long objUserId;
  public int guid;
  public int extend;
  public int passTime;
  public byte bigType;
  public byte smallType;
  public byte jumpType;
  public byte reserve;
  
  public Event() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.srcName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.objName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.srcUserId = b.readLong();
    this.objUserId = b.readLong();
    this.guid = b.readInt();
    this.extend = b.readInt();
    this.passTime = b.readInt();
    this.bigType = b.readByte();
    this.smallType = b.readByte();
    this.jumpType = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
