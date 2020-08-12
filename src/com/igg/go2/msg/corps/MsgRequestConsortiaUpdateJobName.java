package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestConsortiaUpdateJobName extends MsgHead {
  public int guid;
  public ConsortiaJobName jobName;
  
  public MsgRequestConsortiaUpdateJobName() {
    super();
    
    this.jobName = new ConsortiaJobName();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CONSORTIAUPDATEJOBNAME;
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
    this.jobName.writeBuf(b);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + ConsortiaJobName.LENGTH;
  }
  
  public void release() {
    this.jobName.release();
  }
}
