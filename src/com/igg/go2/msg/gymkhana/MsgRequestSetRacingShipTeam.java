package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestSetRacingShipTeam extends MsgHead {
  public int guid;
  public int shipTeamLen;
  public int[] shipTeamId;
  
  public MsgRequestSetRacingShipTeam() {
    super();
    
    this.shipTeamId = new int[MsgTypes.MAX_RACINGSHIPTEAMNUM];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_SETRACINGSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.shipTeamLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_RACINGSHIPTEAMNUM; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.shipTeamId[idx] = b.readInt();
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.shipTeamLen);
    for(int idx = 0; idx < MsgTypes.MAX_RACINGSHIPTEAMNUM; idx++) {
      b.writeInt(this.shipTeamId[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_RACINGSHIPTEAMNUM * 4;
  }
  
  public void release() {
    this.shipTeamId = null;
  }
}
