package com.igg.go2.msg.chat;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgChatMessage extends MsgHead {
  public long srcUserId;
  public long objUserId;
  public int guid;
  public int objGuid;
  public short type;
  public short specialType;
  public int propsId;
  public String name;
  public String toName;
  public String buffer;
  
  public MsgChatMessage() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_CHAT_MESSAGE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.srcUserId = b.readLong();
    this.objUserId = b.readLong();
    this.guid = b.readInt();
    this.objGuid = b.readInt();
    this.type = b.readShort();
    this.specialType = b.readShort();
    this.propsId = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_WIDE);
    this.toName = b.readString(MsgTypes.MAX_NAME , ByteArray.CHARSET_WIDE);
    this.buffer = b.readString(MsgTypes.CHAT_MESSAGE, ByteArray.CHARSET_WIDE);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeLong(this.srcUserId);
    b.writeLong(this.objUserId);
    b.writeInt(this.guid);
    b.writeInt(this.objGuid);
    b.writeShort(this.type);
    b.writeShort(this.specialType);
    b.writeInt(this.propsId);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_WIDE);
    b.writeString(this.toName, MsgTypes.MAX_NAME, ByteArray.CHARSET_WIDE);
    b.writeString(this.buffer, MsgTypes.CHAT_MESSAGE, ByteArray.CHARSET_WIDE);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    /*
     * This value is intentionally not the true sum of the total bytes and is representative of the value in the source instead.
     * Actual length would be 424 bytes.
    */
    return 434;
  }
  
  public void release() {
    //do nothing
  }
}
