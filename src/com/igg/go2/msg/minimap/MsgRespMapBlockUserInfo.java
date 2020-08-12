package com.igg.go2.msg.minimap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespMapBlockUserInfo extends MsgHead {
  public int galaxyId;
  public long userId;
  public String name;
  public String consortiaName;
  
  public MsgRespMapBlockUserInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MAPBLOCKUSERINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyId = b.readInt();
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyId);
    b.writeLong(this.userId);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.consortiaName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_NAME * 2;
  }
  
  public void release() {
    //do nothing
  }
}
