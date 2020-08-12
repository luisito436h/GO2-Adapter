package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCaptureBulletin extends MsgHead {
  public byte roomID;
  public byte bulletinType;
  public short countdown;
  public String leftUserName;
  public String rightUserName;
  public String captureUserName;
  
  public MsgRespCaptureBulletin() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CAPTURE_BULLETIN;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.roomID = b.readByte();
    this.bulletinType = b.readByte();
    this.countdown = b.readShort();
    this.leftUserName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.rightUserName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.captureUserName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + MsgTypes.MAX_NAME * 3;
  }
  
  public void release() {
    //do nothing
  }
}
