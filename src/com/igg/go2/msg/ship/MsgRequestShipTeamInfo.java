package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestShipTeamInfo extends MsgHead {
  public int guid;
  public int galaxyMapId;
  public int galaxyId;
  public int shipTeamId;
  
  public MsgRequestShipTeamInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_SHIPTEAMINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.shipTeamId = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.shipTeamId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24;
  }
  
  public void release() {
    //do nothing
  }
}
