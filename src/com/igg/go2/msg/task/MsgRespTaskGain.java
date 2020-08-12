package com.igg.go2.msg.task;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespTaskGain extends MsgHead {
  public int taskId;
  public int type;
  public int nextTaskId;
  public int completeFlag;
  public int gas;
  public int metal;
  public int money;
  public int propsId;
  public int propsNum;
  public int coins;
  
  public MsgRespTaskGain() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TASKGAIN;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.taskId = b.readInt();
    this.type = b.readInt();
    this.nextTaskId = b.readInt();
    this.completeFlag = b.readInt();
    this.gas = b.readInt();
    this.metal = b.readInt();
    this.money = b.readInt();
    this.propsId = b.readInt();
    this.propsNum = b.readInt();
    this.coins = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 44;
  }
  
  public void release() {
    //do nothing
  }
}
