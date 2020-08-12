package com.igg.go2.msg.facebook;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespFriendInfo extends MsgHead {
  public int objGuid;
  public long objUserId;
  public int galaxyMapId;
  public int galaxyId;
  public int exp;
  public int levelId;
  public int fightFlag;
  public int starType;
  
  public MsgRespFriendInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FRIENDINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.objGuid = b.readInt();
    this.objUserId = b.readLong();
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.exp = b.readInt();
    this.levelId = b.readInt();
    this.fightFlag = b.readInt();
    this.starType = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.objGuid);
    b.writeLong(this.objUserId);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.exp);
    b.writeInt(this.levelId);
    b.writeInt(this.fightFlag);
    b.writeInt(this.starType);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 40;
  }
  
  public void release() {
    //do nothing
  }
}
