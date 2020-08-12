package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestUniteShipTeam extends MsgHead {
  public int guid;
  public int galaxyMapId;
  public int galaxyId;
  public int shipTeamId;
  public int shipTeamId2;
  public int gas;
  public int gas2;
  public ShipTeamNum[] teamBody;
  public ShipTeamNum[] teamBody2;
  
  public MsgRequestUniteShipTeam() {
    super();
    
    this.teamBody = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    this.teamBody2 = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
      this.teamBody2[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_UNITESHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.shipTeamId);
    b.writeInt(this.shipTeamId2);
    b.writeInt(this.gas);
    b.writeInt(this.gas2);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx].writeBuf(b);
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody2[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 36 + ShipTeamNum.LENGTH * MsgTypes.MAX_SHIPTEAMBODY * 2;
    
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
      this.teamBody2[idx].release();
    }
    this.teamBody = null;
    this.teamBody2 = null;
  }
}
