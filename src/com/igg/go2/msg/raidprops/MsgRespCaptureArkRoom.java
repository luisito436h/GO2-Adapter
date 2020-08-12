package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCaptureArkRoom extends MsgHead {
  public short rightPropsID;
  public short leftPropsID;
  public short countdown;
  public byte roomState;
  public byte roomID;
  
  public MsgRespCaptureArkRoom() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CAPTURE_ARK_ROOM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.rightPropsID = b.readShort();
    this.leftPropsID = b.readShort();
    this.countdown = b.readShort();
    this.roomState = b.readByte();
    this.roomID = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12;
  }
  
  public void release() {
    //do nothing
  }
}
