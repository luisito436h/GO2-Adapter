package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_ARENA_PAGE_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ArenaPage {
  public static final short LENGTH = 29 + MsgTypes.MAX_NAME * 2;
  
  public long srcUserId;
  public long objUserId;
  public String srcName;
  public String objName;
  public int srcGuid;
  public int objGuid;
  public int srcShipNum;
  public int objShipNum;
  public byte passKey;
  
  public ArenaPage() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.srcUserId = b.readLong();
    this.objUserId = b.readLong();
    this.srcName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.objName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.srcGuid = b.readInt();
    this.objGuid = b.readInt();
    this.srcShipNum = b.readInt();
    this.objShipNum = b.readInt();
    this.passKey = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
