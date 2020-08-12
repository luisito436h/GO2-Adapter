package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespRacingInfo extends MsgHead {
  public int rankId;
  public int rewardValue;
  public byte racingNum;
  public byte racingRewardFlag;
  public byte enemyLen;
  public byte reportLen;
  public long userId;
  public RacingEnemyInfo[] enemyData;
  public RacingReportInfo[] reportData;
  
  public MsgRespRacingInfo() {
    super();
    
    this.enemyData = new RacingEnemyInfo[MsgTypes.MAX_RACINGENEMYNUM];
    for(int idx = 0; idx < MsgTypes.MAX_RACINGENEMYNUM; idx++) {
      this.enemyData[idx] = new RacingEnemyInfo();
    }
    this.reportData = new RacingReportInfo[MsgTypes.MAX_RACINGREPORTNUM];
    for(int idx = 0; idx < MsgTypes.MAX_RACINGREPORTNUM; idx++) {
      this.reportData[idx] = new RacingReportInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_RACINGINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.rankId = b.readInt();
    this.rewardValue = b.readInt();
    this.racingNum = b.readByte();
    this.racingRewardFlag = b.readByte();
    this.enemyLen = b.readByte();
    this.reportLen = b.readByte();
    this.userId = b.readLong();
    for(int idx = 0; idx < MsgTypes.MAX_RACINGENEMYNUM; idx++) {
      if(b.size() > b.getPosition()) {
        this.enemyData[idx].readBuf(b);
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_RACINGREPORTNUM; idx++) {
      if(b.size() > b.getPosition()) {
        this.reportData[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.rankId);
    b.writeInt(this.rewardValue);
    b.writeByte(this.racingNum);
    b.writeByte(this.racingRewardFlag);
    b.writeByte(this.enemyLen);
    b.writeByte(this.reportLen);
    for(int idx = 0; idx < MsgTypes.MAX_RACINGENEMYNUM; idx++) {
      this.enemyData[idx].writeBuf(b);
    }
    for(int idx = 0; idx < MsgTypes.MAX_RACINGREPORTNUM; idx++) {
      this.reportData[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24
         + RacingEnemyInfo.LENGTH * MsgTypes.MAX_RACINGENEMYNUM
         + RacingReportInfo.LENGTH * MsgTypes.MAX_RACINGREPORTNUM;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_RACINGENEMYNUM - 1; idx >= 0; idx--) {
      this.enemyData[idx].release();
    }
    this.enemyData = null;
    for(int idx = MsgTypes.MAX_RACINGREPORTNUM; idx >= 0; idx--) {
      this.reportData[idx].release();
    }
    this.reportData = null;
  }
}
