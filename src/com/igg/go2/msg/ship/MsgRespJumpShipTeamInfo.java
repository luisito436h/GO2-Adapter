package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespJumpShipTeamInfo extends MsgHead {
  public int dataLen;
  public JumpShipTeamInfo[] data;
  
  public MsgRespJumpShipTeamInfo() {
    super();
    
    this.data = new JumpShipTeamInfo[15];
    for(int idx = 0; idx < 15; idx++) {
      this.data[idx] = new JumpShipTeamInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_JUMPSHIPTEAMINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 15; idx++) {
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
    return 8 + JumpShipTeamInfo.LENGTH * 15;
  }
  
  public void release() {
    for(int idx = 15 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
