package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_MAPAREA_TMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class PlanetInfo {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME * 2;
  
  public String consortiaName;
  public String userName;
  public long userId;
  public int galaxyId;
  public int reserve1;
  public byte starFace;
  public byte insertFlagStatus;
  public byte consortiaHeadId;
  public byte consortiaLevelId;
  public byte type;
  public byte fightFlag;
  public byte camp;
  public byte spaceLevelId;
  
  public PlanetInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.galaxyId = b.readInt();
    this.reserve1 = b.readInt();
    this.starFace = b.readByte();
    this.insertFlagStatus = b.readByte();
    this.consortiaHeadId = b.readByte();
    this.consortiaLevelId = b.readByte();
    this.type = b.readByte();
    this.fightFlag = b.readByte();
    this.camp = b.readByte();
    this.spaceLevelId = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.consortiaName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.userName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.reserve1);
    b.writeByte(this.insertFlagStatus);
    b.writeByte(this.consortiaHeadId);
    b.writeByte(this.consortiaLevelId);
    b.writeByte(this.type);
    b.writeByte(this.fightFlag);
    b.writeByte(this.camp);
    b.writeByte(this.spaceLevelId);
  }
  
  public void release() {
     //do nothing
  }
}
