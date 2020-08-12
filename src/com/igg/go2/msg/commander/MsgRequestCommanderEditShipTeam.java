package com.igg.go2.msg.commander;

import com.igg.go2.msg.ShipTeamNum;
import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCommanderEditShipTeam extends MsgHead {
  public int guid;
  public int shipTeamId;
  public ShipTeamNum[] teamBody;
  public byte target;
  public byte targetInterval;
  public byte type;
  
  public MsgRequestCommanderEditShipTeam() {
    super();
    
    this.teamBody = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_COMMANDEREDITSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.shipTeamId = b.readInt();
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
      }
    }
    
    this.target = b.readByte();
    this.targetInterval = b.readByte();
    this.type = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.shipTeamId);
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx].writeBuf(b);
    }
    
    b.writeByte(this.target);
    b.writeByte(this.targetInterval);
    b.writeByte(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    /*
     * Not technically how getLength is implemented in source but is faster, saner, and gives the same result.
    */
    return 17 + ShipTeamNum.LENGTH * MsgTypes.MAX_SHIPTEAMBODY;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
  }
}
