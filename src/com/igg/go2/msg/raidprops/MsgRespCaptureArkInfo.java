package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCaptureArkInfo extends MsgHead {
  public byte place;
  public byte roomID;
  public byte capture;
  public byte search;
  public short countdown;
  public byte reserve;
  public byte spareType;
  public int spareTime;
  
  public MsgRespCaptureArkInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CAPTURE_ARK_INFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.place = b.readByte();
    this.roomID = b.readByte();
    this.capture = b.readByte();
    this.search = b.readByte();
    this.countdown = b.readShort();
    this.reserve = b.readByte();
    this.spareType = b.readByte();
    this.spareTime = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16;
  }
  
  public void release() {
    //do nothing
  }
}
