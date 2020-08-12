package com.igg.go2.msg.mail;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespReadEmail extends MsgHead {
  public int autoId;
  public int dataLen;
  public String content;
  public AttachedProp[] data;
  
  public MsgRespReadEmail() {
    super();
    
    this.data = new AttachedProp[MsgTypes.MAX_EMAILGOODS];
    for(int idx = 0; idx < MsgTypes.MAX_EMAILGOODS; idx++) {
      this.data[idx] = new AttachedProp();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_READEMAIL;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.autoId = b.readInt();
    this.dataLen = b.readInt();
    this.content = b.readString(MsgTypes.MAX_EMAILCONTENT, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_EMAILGOODS; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + MsgTypes.MAX_EMAILCONTENT + MsgTypes.MAX_EMAILGOODS * AttachedProp.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_EMAILGOODS - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
