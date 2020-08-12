package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCommanderCard extends MsgHead {
  public int propsId;
  public long userId;
  public int cardLevel;
  public String name;
  public int nextCardPropsId1;
  public int nextCardPropsId2;
  public int commanderType;
  public int guid;
  
  public MsgRespCommanderCard() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERCARD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.propsId = b.readInt();
    this.userId = b.readLong();
    this.cardLevel = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.nextCardPropsId1 = b.readInt();
    this.nextCardPropsId2 = b.readInt();
    this.commanderType = b.readInt();
    this.guid = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.propsId);
    b.writeLong(this.userId);
    b.writeInt(this.cardLevel);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.nextCardPropsId1);
    b.writeInt(this.nextCardPropsId2);
    b.writeInt(this.commanderType);
    b.writeInt(this.guid);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 36 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
