package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespJumpShipTeamComplete extends MsgHead {
  public int shipTeamId;
  public int toGalaxyMapId;
  public int toGalaxyId;
  
  public MsgRespJumpShipTeamComplete() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_JUMPSHIPTEAMCOMPLETE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipTeamId = b.readInt();
    this.toGalaxyMapId = b.readInt();
    this.toGalaxyId = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.shipTeamId);
    b.writeInt(this.toGalaxyMapId);
    b.writeInt(this.toGalaxyId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16;
  }
  
  public void release() {
    //do nothing
  }
}
