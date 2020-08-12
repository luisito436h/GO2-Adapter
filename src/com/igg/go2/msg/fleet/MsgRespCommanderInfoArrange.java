package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCommanderInfoArrange extends MsgHead {
  public int dataLen;
  public int[] data;
  
  public MsgRespCommanderInfoArrange() {
    super();
    
    this.data = new int[MsgTypes.MAX_COMMANDERNUM];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERINFOARRANGE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      this.data[idx] = b.readInt();
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + MsgTypes.MAX_COMMANDERNUM * 4;
  }
  
  public void release() {
    this.data = null;
  }
}
