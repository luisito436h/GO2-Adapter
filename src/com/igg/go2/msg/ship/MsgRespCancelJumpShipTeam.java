package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespCancelJumpShipTeam extends MsgHead {
  public int shipTeamId;
  public int needTime;
  
  public MsgRespCancelJumpShipTeam() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CANCELJUMPSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipTeamId = b.readInt();
    this.needTime = b.readInt();
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
