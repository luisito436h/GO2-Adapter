package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIAMEMBER_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class InsertFlagMember {
  public static final short LENGTH = MsgTypes.MAX_NAME + 16;
  
  public String name;
  public int guid;
  public int galaxyId;
  public int assault;
  public short galaxyArea;
  public byte levelId;
  public byte job;
  
  public InsertFlagMember() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.guid = b.readInt();
    this.galaxyId = b.readInt();
    this.assault = b.readInt();
    this.galaxyArea = b.readShort();
    this.levelId = b.readByte();
    this.job = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
