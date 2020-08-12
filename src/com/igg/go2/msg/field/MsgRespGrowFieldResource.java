package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespGrowFieldResource extends MsgHead {
  public int resourceId;
  public int errorCode;
  public int needTime;
  public int galaxyId;
  public int num;
  
  public MsgRespGrowFieldResource() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GROWFIELDRESOURCE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.resourceId = b.readInt();
    this.errorCode = b.readInt();
    this.needTime = b.readInt();
    this.galaxyId = b.readInt();
    this.num = b.readInt();
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
