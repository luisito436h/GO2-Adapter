package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestCommanderInsertStone extends MsgHead {
  public int guid;
  public int type;
  public int commanderId;
  public int holeId;
  public int propsId;
  public int lockFlag;
  
  public MsgRequestCommanderInsertStone() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_COMMANDERINSERTSTONE;
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
    b.writeInt(this.type);
    b.writeInt(this.commanderId);
    b.writeInt(this.holeId);
    b.writeInt(this.propsId);
    b.writeInt(this.lockFlag);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32;
  }
  
  public void release() {
    //do nothing
  }
}
