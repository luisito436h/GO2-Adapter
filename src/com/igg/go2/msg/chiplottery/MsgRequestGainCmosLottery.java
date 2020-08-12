package com.igg.go2.msg.chiplottery;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestGainCmosLottery extends MsgHead {
  public int guid;
  public int phaseId;
  public int type;
  
  public MsgRequestGainCmosLottery () {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_GAINCMOSLOTTERY;
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
    b.writeInt(this.phaseId);
    b.writeInt(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
