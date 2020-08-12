package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespResumeCommander extends MsgHead {
  public int commanderId;
  public int propsId;
  public int lockFlag;
  
  public MsgRespResumeCommander() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_RESUMECOMMANDER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.commanderId = b.readInt();
    this.propsId = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.commanderId);
    b.writeInt(this.propsId);
    b.writeInt(this.lockFlag);
    
    b.padSize(super.usSize);
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
