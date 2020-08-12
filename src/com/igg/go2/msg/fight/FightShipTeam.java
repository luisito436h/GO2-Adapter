package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.fleet.ShipTeamBody;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FIGHTINIT_SHIPTEAM_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FightShipTeam {
  public static final short LENGTH = 28
                                   + MsgTypes.MAX_NAME * 4
                                   + MsgTypes.MAX_SHIPTEAMBODY * 16
                                   + MsgTypes.MAX_SHIPTEAMBODY * ShipTeamBody.LENGTH;
  
  public String teamName;
  public String commander;
  public String teamOwner;
  public String consortia;
  public long userId;
  public int shipTeamId;
  public int gas;
  public int storage;
  public int[] maxShield;
  public int[] maxEndure;
  public int[] shield;
  public int[] endure;
  public ShipTeamBody[] teamBody;
  public short skillId;
  public short reserve;
  public byte attackObjInterval;
  public byte attackObjType;
  public byte levelId;
  public byte cardLevel;
  
  public FightShipTeam() {
    super();
    
    this.maxShield = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.maxEndure = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.shield = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.endure = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.teamBody = new ShipTeamBody[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamBody();
    }
  }
  
  public void readBuf(ByteArray b) {
    this.teamName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.commander = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.teamOwner = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortia = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.shipTeamId = b.readInt();
    this.gas = b.readInt();
    this.storage = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.maxShield[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.maxEndure[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.shield[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.endure[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
      }
    }
    this.skillId = b.readShort();
    this.reserve = b.readShort();
    this.attackObjInterval = b.readByte();
    this.attackObjType = b.readByte();
    this.levelId = b.readByte();
    this.cardLevel = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     this.maxShield = null;
     this.maxEndure = null;
     this.shield = null;
     this.endure = null;
     for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
       this.teamBody[idx].release();
     }
     this.teamBody = null;
  }
}
