package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ConsortiaInfo {
  public static final short LENGTH = MsgTypes.MAX_NAME + 8;
  
  public String name;
  public int consortiaId;
  public int rankId;
  
  public ConsortiaInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortiaId = b.readInt();
    this.rankId = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.consortiaId);
    b.writeInt(this.rankId);
  }
  
  public void release() {
     //do nothing
  }
}
