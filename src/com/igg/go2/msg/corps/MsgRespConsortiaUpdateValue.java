package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespConsortiaUpdateValue extends MsgHead {
  public int needUnionValue;
  public int needShopValue;
  
  public MsgRespConsortiaUpdateValue() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAUPDATAVALUE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.needUnionValue = b.readInt();
    this.needShopValue = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12;
  }
  
  public void release() {
    //do nothing
  }
}
