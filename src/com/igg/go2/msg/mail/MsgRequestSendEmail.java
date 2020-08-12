package com.igg.go2.msg.mail;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestSendEmail extends MsgHead {
  public int guid;
  public int sendGuid;
  public String title;
  public String content;
  
  public MsgRequestSendEmail() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_SENDEMAIL;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.sendGuid = b.readInt();
    this.title = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.content = b.readString(MsgTypes.MAX_EMAILCONTENT, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.sendGuid);
    b.writeString(this.title, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.content, MsgTypes.MAX_EMAILCONTENT, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_NAME + MsgTypes.MAX_EMAILCONTENT;
  }
  
  public void release() {
    //do nothing
  }
}
