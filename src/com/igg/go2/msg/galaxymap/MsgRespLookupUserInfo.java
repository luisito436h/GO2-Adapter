package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespLookupUserInfo extends MsgHead {
  public int guid;
  public long userId;
  public String userName;
  public int posX;
  public int posY;
  public int galaxyId;
  public int type;
  
  public MsgRespLookupUserInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_LOOKUPUSERINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.userId = b.readLong();
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.posX = b.readInt();
    this.posY = b.readInt();
    this.galaxyId = b.readInt();
    this.type = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.guid);
    b.writeLong(this.userId);
    b.writeString(this.userName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.posX);
    b.writeInt(this.posY);
    b.writeInt(this.galaxyId);
    b.writeInt(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
