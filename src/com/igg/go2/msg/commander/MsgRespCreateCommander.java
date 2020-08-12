package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCreateCommander extends MsgHead {
  public int nextInviteTime;
  public CommanderBaseInfo data;
  
  public MsgRespCreateCommander() {
    super();
    
    this.data = new CommanderBaseInfo();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATECOMMANDER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.nextInviteTime = b.readInt();
    this.data.readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.nextInviteTime);
    this.data.writeBuf(b);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + CommanderBaseInfo.LENGTH;
  }
  
  public void release() {
    //do nothing
  }
}
