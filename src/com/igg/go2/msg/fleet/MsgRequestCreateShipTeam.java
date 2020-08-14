package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCreateShipTeam extends MsgHead {
  public int guid;
  public String teamName;
  public ShipTeamNum[] teamBody;
  public int commanderId;
  public byte target;
  public byte targetInterval;
  
  public MsgRequestCreateShipTeam() {
    super();
    
    this.teamBody = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATESHIPTEAM;
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
    b.writeString(this.teamName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx].writeBuf(b);
    }
    b.writeInt(this.commanderId);
    b.writeByte(this.target);
    b.writeByte(this.targetInterval);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 18 + MsgTypes.MAX_NAME + MsgTypes.MAX_SHIPTEAMBODY * ShipTeamNum.LENGTH;
  }
  
  public void release() {
    //do nothing
  }
}
