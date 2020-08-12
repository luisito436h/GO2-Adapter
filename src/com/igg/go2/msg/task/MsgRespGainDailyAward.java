package com.igg.go2.msg.task;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespGainDailyAward extends MsgHead {
  public int dailyAwardId;
  public int propsId;
  public int lockFlag;
  public int propsNum;
  
  public MsgRespGainDailyAward() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GAINDAILYAWARD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dailyAwardId = b.readInt();
    this.propsId = b.readInt();
    this.lockFlag = b.readInt();
    this.propsNum = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
