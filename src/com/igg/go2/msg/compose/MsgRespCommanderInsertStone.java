package com.igg.go2.msg.compose;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCommanderInsertStone extends MsgHead {
  public int type;
  public int commanderId;
  public int holeId;
  public int propsId;
  public int lockFlag;
  
  public MsgRespCommanderInsertStone() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERINSERTSTONE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.commanderId = b.readInt();
    this.holeId = b.readInt();
    this.propsId = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24;
  }
  
  public void release() {
    //do nothing
  }
}
