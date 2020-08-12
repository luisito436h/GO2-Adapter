package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestCaptureState extends MsgHead {
  public int guid;
  public byte roomID;
  public byte request;
  
  public MsgRequestCaptureState() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CAPTURE_STATE;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeByte(this.roomID);
    b.writeByte(this.request);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 14;
  }
  
  public void release() {
    //do nothing
  }
}
