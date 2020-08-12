package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ConsortiaJobName {
  public static final short LENGTH = MsgTypes.MAX_NAME * 5;
  
  public String name0;
  public String name1;
  public String name2;
  public String name3;
  public String name4;
  
  public ConsortiaJobName() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name0 = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.name1 = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.name2 = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.name3 = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.name4 = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name0, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.name1, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.name2, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.name3, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.name4, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  
  public void release() {
     //do nothing
  }
}
