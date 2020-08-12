package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ship.ShipFight;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFightSection extends MsgHead {
  public int galaxyId;
  public short needTime;
  public short boutId;
  public int srcShipTeamId;
  public int objShipTeamId;
  public int srcRepairSupply;
  public int[] srcRepairShield;
  public int[] srcRepairEndure;
  public int[] objRepairShield;
  public int[] objRepairEndure;
  public byte galaxyMapId;
  public byte srcSkill;
  public byte srcDirection;
  public byte delFlag;
  public byte bothStatus;
  public byte repelStep;
  public byte[] srcMovePath;
  public byte[] objMatrixId;
  public ShipFight[] shipFight;
  
  public MsgRespFightSection() {
    super();
    
    /*
     * MAX_SHIPTEAMBODY and MAX_FIGHTMOVEPATH were declared in-class in source
     * but since the same values are already in MsgTypes, using those instead.
    */
    this.srcRepairShield = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.srcRepairEndure = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.objRepairShield = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.objRepairEndure = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.srcMovePath = new byte[MsgTypes.MAX_FIGHTMOVEPATH];
    this.objMatrixId = new byte[MsgTypes.MAX_SHIPTEAMBODY];
    this.shipFight = new ShipFight[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.shipFight[idx] = new ShipFight();
      this.objMatrixId[idx] = -1;
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIGHTSECTION;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyId = b.readInt();
    this.needTime = b.readShort();
    this.boutId = b.readShort();
    this.srcShipTeamId = b.readInt();
    this.objShipTeamId = b.readInt();
    this.srcRepairSupply = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.srcRepairShield[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.srcRepairEndure[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.objRepairShield[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.objRepairEndure[idx] = b.readInt();
      }
    }
    this.galaxyMapId = b.readByte();
    this.srcSkill = b.readByte();
    this.srcDirection = b.readByte();
    this.delFlag = b.readByte();
    this.bothStatus = b.readByte();
    this.repelStep = b.readByte();
    for(int idx = 0; idx < MsgTypes.MAX_FIGHTMOVEPATH; idx++) {
      this.srcMovePath[idx] = b.readByte();
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.objMatrixId[idx] = b.readByte();
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.shipFight[idx].readBuf(b);
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
    return (short)(30
         + MsgTypes.MAX_SHIPTEAMBODY * 17
         + MsgTypes.MAX_FIGHTMOVEPATH
         + ShipFight.LENGTH * MsgTypes.MAX_SHIPTEAMBODY);
  }
  
  public void release() {
    this.srcRepairShield = null;
    this.srcRepairEndure = null;
    this.objRepairShield = null;
    this.objRepairEndure = null;
    this.srcMovePath = null;
    this.objMatrixId = null;
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.shipFight[idx].release();
    }
    this.shipFight = null;
  }
}
