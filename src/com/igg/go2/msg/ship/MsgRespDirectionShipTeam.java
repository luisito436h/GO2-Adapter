package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespDirectionShipTeam extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int shipTeamId;
  public byte direction;
  
  public MsgRespDirectionShipTeam() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_DIRECTIONSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.shipTeamId = b.readInt();
    this.direction = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.shipTeamId);
    b.writeByte(this.direction);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 17;
  }
  
  public void release() {
    //do nothing
  }
}
