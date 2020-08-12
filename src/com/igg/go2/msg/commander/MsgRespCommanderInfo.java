package com.igg.go2.msg.commander;

import com.igg.go2.msg.ShipTeamNum;
import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCommanderInfo extends MsgHead {
  public int commanderId;
  public int shipTeamId;
  public int restTime;
  public int exp;
  public short aim;
  public short blench;
  public short priority;
  public short electron;
  public short skill;
  public short cardLevel;
  public byte level;
  public byte type;
  public byte state;
  public byte showType;
  public String commanderZJ;
  public ShipTeamNum[] teamBody;
  public byte target;
  public byte targetInterval;
  public byte reserve;
  public byte allStatusLen;
  public CommanderInfo[] allStatus;
  public short[] stone;
  public int stoneHole;
  public byte aimPer;
  public byte blenchPer;
  public byte priorityPer;
  public byte electronPer;
  public int[] cmosExp;
  public short[] cmos;
  
  public MsgRespCommanderInfo() {
    super();
    
    this.teamBody = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    this.allStatus = new CommanderInfo[MsgTypes.MAX_COMMANDERNUM];
    this.stone = new short[MsgTypes.MAX_COMMANDERSTONE];
    this.cmosExp = new int[MsgTypes.MAX_COMMANDERCMOS];
    this.cmos = new short[MsgTypes.MAX_COMMANDERCMOS];
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamNum();
    }
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      this.allStatus[idx] = new CommanderInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.commanderId = b.readInt();
    this.shipTeamId = b.readInt();
    this.restTime = b.readInt();
    this.exp = b.readInt();
    this.aim = b.readShort();
    this.blench = b. readShort();
    this.priority = b.readShort();
    this.electron = b.readShort();
    this.skill = b.readShort();
    this.cardLevel = b.readShort();
    this.level = b.readByte();
    this.type = b.readByte();
    this.state = b.readByte();
    this.showType = b.readByte();
    this.commanderZJ = b.readString(MsgTypes.COMMANDERZJCOUNT, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
      }
    }
    this.target = b.readByte();
    this.targetInterval = b.readByte();
    this.reserve = b.readByte();
    this.allStatusLen = b.readByte();
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      if(b.size() > b.getPosition()) {
        this.allStatus[idx].readBuf(b);
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERSTONE; idx++) {
      if(b.size() > b.getPosition()) {
        this.allStatus[idx].readBuf(b);
      }
    }
    this.stoneHole = b.readInt();
    this.aimPer = b.readByte();
    this.blenchPer = b.readByte();
    this.priorityPer = b.readByte();
    this.electronPer = b.readByte();
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERCMOS; idx++) {
      if(b.size() > b.getPosition()) {
        this.cmosExp[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERCMOS; idx++) {
      if(b.size() > b.getPosition()) {
        this.cmos[idx] = b.readShort();
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
    /*
     * Not technically how getLength is implemented in source but is faster, saner, and gives the same result.
    */
    return 48
         + MsgTypes.MAX_COMMANDERSTONE * 2
         + MsgTypes.MAX_COMMANDERCMOS * 6
         + MsgTypes.MAX_SHIPTEAMBODY * ShipTeamNum.LENGTH
         + MsgTypes.MAX_COMMANDERNUM * CommanderInfo.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
    
    for(int idx = MsgTypes.MAX_COMMANDERNUM - 1; idx >= 0; idx--) {
      this.allStatus[idx].release();
    }
    this.allStatus = null;
    
    this.stone = null;
    this.cmosExp = null;
    this.cmos = null;
  }
}
