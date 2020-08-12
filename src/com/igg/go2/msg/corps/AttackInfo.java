package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAATTACKINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class AttackInfo {
  public static final short LENGTH = MsgTypes.MAX_NAME * 3 + 40;
  
  public String srcName;
  public String srcConsortiaName;
  public String objName;
  public long srcUserId;
  public long objUserId;
  public int objGuid;
  public int objGalaxyId;
  public int srcGuid;
  public int srcGalaxyId;
  public int needTime;
  public int reserve;
  
  public AttackInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.srcName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.srcConsortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.objName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.srcUserId = b.readLong();
    this.objUserId = b.readLong();
    this.objGuid = b.readInt();
    this.objGalaxyId = b.readInt();
    this.srcGuid = b.readInt();
    this.srcGalaxyId = b.readInt();
    this.needTime = b.readInt();
    this.reserve = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
