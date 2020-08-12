  package com.igg.go2.msg.chat;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespUserInfo extends MsgHead {
  public int guid;
  public long userId;
  public String userName;
  public String consortia;
  public int rankId;
  public int posX;
  public int posY;
  public int peaceTime;
  public int galaxyId;
  public byte spaceLevel;
  public byte cityLevel;
  public byte usLevelId;
  public byte usMatchLevel;
  public int passMaxEctypt;
  public int consortiaId;
  public int passInsertFlagTime;
  public int insertFlagConsortiaId;
  public String insertFlagConsortia;
  
  public MsgRespUserInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_USERINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.userId = b.readLong();
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortia = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.rankId = b.readInt();
    this.posX = b.readInt();
    this.posY = b.readInt();
    this.peaceTime = b.readInt();
    this.galaxyId = b.readInt();
    this.spaceLevel = b.readByte();
    this.cityLevel = b.readByte();
    this.usLevelId = b.readByte();
    this.usMatchLevel = b.readByte();
    this.passMaxEctypt = b.readInt();
    this.consortiaId = b.readInt();
    this.passInsertFlagTime = b.readInt();
    this.insertFlagConsortiaId = b.readInt();
    this.insertFlagConsortia = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 48 + MsgTypes.MAX_NAME * 3;
  }
  
  public void release() {
    //do nothing
  }
}
