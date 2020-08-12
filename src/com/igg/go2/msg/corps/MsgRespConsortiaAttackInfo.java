package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaAttackInfo extends MsgHead {
  public short attackCount;
  public short dataLen;
  public AttackInfo[] data;
  
  public MsgRespConsortiaAttackInfo() {
    super();
    
    this.data = new AttackInfo[6];
    for(int idx = 0; idx < 6; idx++) {
      this.data[idx] = new AttackInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAATTACKINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.attackCount = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < 6; idx++) {
      if(b.size() > b.getPosition()) {
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
    return 8 + AttackInfo.LENGTH * 6;
  }
  
  public void release() {
    for(int idx = 6 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
