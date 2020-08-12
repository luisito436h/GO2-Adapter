package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCreateShipModel extends MsgHead {
  public int guid;
  public String shipName;
  public short bodyId;
  public short partNum;
  public short[] partId;
  
  public MsgRequestCreateShipModel() {
    super();
    
    this.partId = new short[MsgTypes.MAX_SHIPPART];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATESHIPMODEL;
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
    b.writeString(this.shipName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeShort(this.bodyId);
    b.writeShort(this.partNum);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPPART; idx++) {
      b.writeShort(this.partId[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16
         + MsgTypes.MAX_NAME
         + MsgTypes.MAX_SHIPPART * 2;
  }
  
  public void release() {
    this.partId = null;
  }
}
