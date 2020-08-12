package com.igg.go2.msg.task;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_TASKINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TaskInfo {
  public static final short LENGTH = 8;
  
  public short taskId;
  public short num;
  public byte type;
  public byte levelId;
  public byte completeFlag;
  public byte gainFlag;
  
  public TaskInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.taskId = b.readShort();
    this.num = b.readShort();
    this.type = b.readByte();
    this.levelId = b.readByte();
    this.completeFlag = b.readByte();
    this.gainFlag = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
