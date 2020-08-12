package com.igg.go2.msg.loadhe3;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespLoadShipTeam extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int shipTeamId;
  public int gas;
  
  public MsgRespLoadShipTeam() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_LOADSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.shipTeamId = b.readInt();
    this.gas = b.readInt();
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
