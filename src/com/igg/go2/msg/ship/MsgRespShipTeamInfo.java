package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.fleet.ShipTeamBody;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespShipTeamInfo extends MsgHead {
  public int shipTeamId;
  public long userId;
  public int gas;
  public int commanderId;
  public String teamName;
  public String commander;
  public String teamOwner;
  public String consortia;
  public ShipTeamBody[] teamBody;
  public short skillId;
  public byte attackObjInterval;
  public byte attackObjType;
  public byte levelId;
  public byte cardLevel;
  
  public MsgRespShipTeamInfo() {
    super();
    
    this.teamBody = new ShipTeamBody[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx] = new ShipTeamBody();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPTEAMINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipTeamId = b.readInt();
    this.userId = b.readLong();
    this.gas = b.readInt();
    this.commanderId = b.readInt();
    this.teamName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.commander = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.teamOwner = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortia = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.size() > b.getPosition()) {
        this.teamBody[idx].readBuf(b);
      }
    }
    this.skillId = b.readShort();
    this.attackObjInterval = b.readByte();
    this.attackObjType = b.readByte();
    this.levelId = b.readByte();
    this.cardLevel = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.shipTeamId);
    b.writeLong(this.userId);
    b.writeInt(this.gas);
    b.writeInt(this.commanderId);
    b.writeString(this.teamName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.commander, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.teamOwner, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeString(this.consortia, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.teamBody[idx].writeBuf(b);
    }
    b.writeShort(this.skillId);
    b.writeByte(this.attackObjInterval);
    b.writeByte(this.attackObjType);
    b.writeByte(this.levelId);
    b.writeByte(this.cardLevel);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 30
         + MsgTypes.MAX_NAME * 4
         + ShipTeamBody.LENGTH * MsgTypes.MAX_SHIPTEAMBODY;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
      this.teamBody[idx].release();
    }
    this.teamBody = null;
  }
}
