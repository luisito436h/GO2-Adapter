package com.igg.go2.msg.chat;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespGalaxyBroadcast extends MsgHead {
  public int guid;
  public long userId;
  public String name;
  public int type;
  
  public MsgRespGalaxyBroadcast() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GALAXYBROADCAST;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.type = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.guid);
    b.writeLong(this.userId);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
