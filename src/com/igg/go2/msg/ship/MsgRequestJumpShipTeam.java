package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestJumpShipTeam extends MsgHead {
  public int guid;
  public int toGalaxyMapId;
  public int toGalaxyId;
  public short dataLen;
  public byte jumpType;
  public byte type;
  public int[] shipTeamId;
  
  public MsgRequestJumpShipTeam() {
    super();
    
    this.shipTeamId = new int[100];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_JUMPSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.toGalaxyMapId = b.readInt();
    this.toGalaxyId = b.readInt();
    this.dataLen = b.readShort();
    this.jumpType = b.readByte();
    this.type = b.readByte();
    for(int idx = 0; idx < 100; idx++) {
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
    b.writeInt(this.toGalaxyMapId);
    b.writeInt(this.toGalaxyId);
    b.writeShort(this.dataLen);
    b.writeByte(this.jumpType);
    b.writeByte(this.type);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 428;
  }
  
  public void release() {
    this.shipTeamId = null;
  }
}
