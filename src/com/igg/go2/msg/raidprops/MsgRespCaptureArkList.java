/*
 * Used exclusively for quickly writing new Msg classes.
 * Do not fix errors. Remove before compile.
 */

package com.igg.go2.msg.raidprops;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCaptureArkList extends MsgHead {
  public byte searchFleets;
  public byte captureFleets;
  public byte reserve;
  public byte dataLen;
  public CaptureArk[] room;
  
  public MsgRespCaptureArkList() {
    super();
    
    this.room = new CaptureArk[100];
    for(int idx = 0; idx < 100; idx++) {
      this.room[idx] = new CaptureArk();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CAPTURE_ARK_LIST;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.searchFleets = b.readByte();
    this.captureFleets = b.readByte();
    this.reserve = b.readByte();
    this.dataLen = b.readByte();
    for(int idx = 0; idx < 100; idx++) {
      if(b.size() > b.getPosition()) {
        this.room[idx].readBuf(b);
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
    return 8 + CaptureArk.LENGTH * 100;
  }
  
  public void release() {
    for(int idx = 100 - 1; idx >= 0; idx--) {
      this.room[idx].release();
    }
    this.room = null;
  }
}
