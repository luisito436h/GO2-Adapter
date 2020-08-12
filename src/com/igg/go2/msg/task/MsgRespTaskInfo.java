package com.igg.go2.msg.task;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTaskInfo extends MsgHead {
  public short dataLen;
  public short awardLen;
  public byte[] awardData;
  public TaskInfo[] data;
  
  public MsgRespTaskInfo() {
    super();
    
    this.awardData = new byte[24];
    this.data = new TaskInfo[100];
    for(int idx = 0; idx < 100; idx++) {
      this.data[idx] = new TaskInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TASKINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readShort();
    this.awardLen = b.readShort();
    for(int idx = 0; idx < 24; idx++) {
      this.awardData[idx] = b.readByte();
    }
    for(int idx = 0; idx < 100; idx++) {
      if(b.sizeRemaining() > TaskInfo.LENGTH) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32 + TaskInfo.LENGTH * 100;
  }
  
  public void release() {
    this.awardData = null;
    for(int idx = 100 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
