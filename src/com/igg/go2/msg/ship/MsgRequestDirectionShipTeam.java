package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestDirectionShipTeam extends MsgHead {
  public int guid;
  public int shipTeamId;
  public byte direction;
  
  public MsgRequestDirectionShipTeam() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_DIRECTIONSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.shipTeamId = b.readInt();
    this.direction = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
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
