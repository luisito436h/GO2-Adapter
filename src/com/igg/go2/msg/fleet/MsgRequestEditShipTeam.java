package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestEditShipTeam extends MsgHead {
  public int guid;
  public int shipTeamId;
  public String teamName;
  public ShipTeamNum[] teamBody;
  public int commanderId;
  public byte target;
  public byte targetInterval;
  public byte editType;
  
  public MsgRequestEditShipTeam() {
    super();
    
    this.teamBody = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_EDITSHIPTEAM;
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
    b.writeInt(this.shipTeamId);
    b.writeString(this.teamName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx].writeBuf(b);
    }
    b.writeInt(this.commanderId);
    b.writeByte(this.target);
    b.writeByte(this.targetInterval);
    b.writeByte(this.editType);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
     return 23 + MsgTypes.MAX_NAME + ShipTeamNum.LENGTH * MsgTypes.MAX_SHIPTEAMBODY;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
  }
}
