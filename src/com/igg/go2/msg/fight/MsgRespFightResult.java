package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFightResult extends MsgHead {
  public short type;
  public short galaxyMapId;
  public long topAssault_userId;
  public int galaxyId;
  public String topAssault_modelName;
  public String topAssault_commander;
  public String topAssault_owner;
  public int topAssault_value;
  public short topAssault_bodyId;
  public short victory;
  public int attackShipNumber;
  public int attackLossNumber;
  public int defendShipNumber;
  public int defendLossNumber;
  public FightTotalKill[] kill;
  public FightTotalExp[] exp;
  public FightRobResource[] prize;
  
  public MsgRespFightResult() {
    super();
    
    this.kill = new FightTotalKill[MsgTypes.MAX_FIGHTRESULTKILL];
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTKILL; idx++) {
      this.kill[idx] = new FightTotalKill();
    }
    this.exp = new FightTotalExp[MsgTypes.MAX_FIGHTRESULTEXP];
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTEXP; idx++) {
      this.exp[idx] = new FightTotalExp();
    }
    this.prize = new FightRobResource[MsgTypes.MAX_FIGHTRESULTPRIZE];
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTPRIZE; idx++) {
      this.prize[idx] = new FightRobResource();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIGHTRESULT;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readShort();
    this.galaxyMapId = b.readShort();
    this.topAssault_userId = b.readLong();
    this.galaxyId = b.readInt();
    this.topAssault_modelName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.topAssault_commander = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.topAssault_owner = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.topAssault_value = b.readInt();
    this.topAssault_bodyId = b.readShort();
    this.victory = b.readShort();
    this.attackShipNumber = b.readInt();
    this.attackLossNumber = b.readInt();
    this.defendShipNumber = b.readInt();
    this.defendLossNumber = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTKILL; idx++) {
      if(b.size() > b.getPosition()) {
        this.kill[idx].readBuf(b);
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTEXP; idx++) {
      if(b.size() > b.getPosition()) {
        this.exp[idx].readBuf(b);
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTRESULTPRIZE; idx++) {
      if(b.size() > b.getPosition()) {
        this.prize[idx].readBuf(b);
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
    return 44
         + MsgTypes.MAX_NAME * 3
         + MsgTypes.MAX_FIGHTRESULTKILL * FightTotalKill.LENGTH
         + MsgTypes.MAX_FIGHTRESULTEXP * FightTotalExp.LENGTH
         + MsgTypes.MAX_FIGHTRESULTPRIZE * FightRobResource.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_FIGHTRESULTKILL - 1; idx >= 0; idx--) {
      this.kill[idx].release();
    }
    this.kill = null;
    for(int idx = MsgTypes.MAX_FIGHTRESULTEXP - 1; idx >= 0; idx--) {
      this.exp[idx].release();
    }
    this.exp = null;
    for(int idx = MsgTypes.MAX_FIGHTRESULTPRIZE - 1; idx >= 0; idx--) {
      this.prize[idx].release();
    }
    this.prize = null;
  }
}
