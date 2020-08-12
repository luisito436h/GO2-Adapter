package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFortressSection extends MsgHead {
  public int galaxyId;
  public int srcId;
  public short galaxyMapId;
  public short boutId;
  public byte buildType;
  public byte reserve0;
  public byte reserve1;
  public byte dataLen;
  public FortressFight[] shipFight;
  
  public MsgRespFortressSection() {
    super();
    
    this.shipFight = new FortressFight[25];
    for(int idx = 0; idx < 25; idx++) {
      this.shipFight[idx] = new FortressFight();
    }
    this.galaxyMapId = -1;
    this.galaxyId = -1;
    this.boutId = -1;
    this.srcId = -1;
    this.buildType = -1;
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIGHTFORTRESSSECTION;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyId = b.readInt();
    this.srcId = b.readInt();
    this.galaxyMapId = b.readShort();
    this.boutId = b.readShort();
    this.buildType = b.readByte();
    this.reserve0 = b.readByte();
    this.reserve1 = b.readByte();
    this.dataLen = b.readByte();
    for(int idx = 0; idx < 25; idx++) {
      if(b.size() > b.getPosition()) {
        this.shipFight[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyId);
    b.writeInt(this.srcId);
    b.writeShort(this.galaxyMapId);
    b.writeShort(this.boutId);
    b.writeByte(this.buildType);
    b.writeByte(this.reserve0);
    b.writeByte(this.reserve1);
    b.writeByte(this.dataLen);
    for(int idx = 0; idx < 25; idx++) {
      this.shipFight[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20 + FortressFight.LENGTH * 25;
  }
  
  public void release() {
    for(int idx = 25 - 1; idx >= 0; idx--) {
      this.shipFight[idx].release();
    }
    this.shipFight = null;
  }
}
