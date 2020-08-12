package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFightInitShipTeam extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int dataLen;
  /*
   * This array was accessed through loops in the source, but since it's
   * only 2 long, it's faster to simply hardcode it.
  */
  public FightShipTeam[] data;
  
  public MsgRespFightInitShipTeam() {
    super();
    
    this.data = new FightShipTeam[2];
    this.data[0] = new FightShipTeam();
    this.data[1] = new FightShipTeam();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIGHTINIT_SHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.dataLen = b.readInt();
    this.data[0].readBuf(b);
    this.data[1].readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.dataLen);
    this.data[0].writeBuf(b);
    this.data[1].writeBuf(b);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + FightShipTeam.LENGTH * 2;
  }
  
  public void release() {
    this.data[1].release();
    this.data[0].release();
    this.data = null;
  }
}
