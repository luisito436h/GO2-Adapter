package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespArrangeShipTeam extends MsgHead {
  public short dataLen;
  public short type;
  public ShipTeamNum[] teamBody;
  
  public MsgRespArrangeShipTeam() {
    super();
    
    this.teamBody = new ShipTeamNum[120];
    for(int idx = 0; idx < 120; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ARRANGESHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readShort();
    this.type = b.readShort();
    for(int idx = 0; idx < 120; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
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
    return 8 + ShipTeamNum.LENGTH * 120;
  }
  
  public void release() {
    for(int idx = 120 - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
  }
}
