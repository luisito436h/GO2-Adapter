package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.fleet.ShipTeamBody;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespViewJumpShipTeam extends MsgHead {
  public ShipTeamBody[] teamBody;
  public long userId;
  public long commanderUserId;
  public String teamName;
  public String teamOwner;
  public int shipTeamId;
  public short aim;
  public short blench;
  public short priority;
  public short electron;
  public short skillId;
  public byte cardLevel;
  
  public MsgRespViewJumpShipTeam() {
    super();
    
    this.teamBody = new ShipTeamBody[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamBody();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_VIEWJUMPSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
      }
    }
    this.userId = b.readLong();
    this.commanderUserId = b.readLong();
    this.teamName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.teamOwner = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.shipTeamId = b.readInt();
    this.aim = b.readShort();
    this.blench = b.readShort();
    this.priority = b.readShort();
    this.electron = b.readShort();
    this.skillId = b.readShort();
    this.cardLevel = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 31
         + MsgTypes.MAX_NAME * 2
         + ShipTeamBody.LENGTH * MsgTypes.MAX_SHIPTEAMBODY;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
  }
}
