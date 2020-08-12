package com.igg.go2.msg.field;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FIELDRESOURCELOG_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FieldResourceLog {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME;
  
  public long userId;
  public String name;
  public int guid;
  public int gas;
  public int money;
  public int metal;
  
  public FieldResourceLog() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.guid = b.readInt();
    this.gas = b.readInt();
    this.money = b.readInt();
    this.metal = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
