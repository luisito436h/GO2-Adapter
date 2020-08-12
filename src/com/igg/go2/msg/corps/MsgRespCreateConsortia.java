package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCreateConsortia extends MsgHead {
  public int consortiaId;
  public int propsCorpsPack;
  public byte errorCode;
  public byte lockFlag;
  
  public MsgRespCreateConsortia() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATECONSORTIA;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaId = b.readInt();
    this.propsCorpsPack = b.readInt();
    this.errorCode = b.readByte();
    this.lockFlag = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
