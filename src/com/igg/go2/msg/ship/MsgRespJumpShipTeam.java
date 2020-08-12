package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespJumpShipTeam extends MsgHead {
  public JumpShipTeamInfo data;
  
  public MsgRespJumpShipTeam() {
    super();
    
    this.data = new JumpShipTeamInfo();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_JUMPSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.data.readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return JumpShipTeamInfo.LENGTH;
  }
  
  public void release() {
    this.data.release();
  }
}
