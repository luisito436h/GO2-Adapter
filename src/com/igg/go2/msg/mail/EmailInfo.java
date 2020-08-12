package com.igg.go2.msg.mail;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_EMAILINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class EmailInfo {
  public static final short LENGTH = 32 + MsgTypes.MAX_NAME * 2;
  
  public String title;
  public String name;
  public long dateTime;
  public long srcUserId;
  public int srcGuid;
  public int autoId;
  public int fightGalaxyId;
  public byte type;
  public byte readFlag;
  public byte goodFlag;
  public byte titleType;
  public byte fromSystem;
  
  public EmailInfo() {
    super();
    
    this.fromSystem = -1;
  }
  
  public void readBuf(ByteArray b) {
   this.title = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
   this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
   this.dateTime = b.readLong();
   this.srcUserId = b.readLong();
   this.srcGuid = b.readInt();
   this.autoId = b.readInt();
   this.fightGalaxyId = b.readInt();
   this.type = b.readByte();
   this.readFlag = b.readByte();
   this.goodFlag = b.readByte();
   this.titleType = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
