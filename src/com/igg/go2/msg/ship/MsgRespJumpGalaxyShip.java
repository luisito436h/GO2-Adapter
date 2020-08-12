package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespJumpGalaxyShip extends MsgHead {
  public int galaxyId;
  public byte dataLen;
  public byte type;
  public byte galaxyMapId;
  public byte jumpType;
  public JumpGalaxyShip[] data;
  
  public MsgRespJumpGalaxyShip() {
    super();
    
    this.data = new JumpGalaxyShip[18];
    for(int idx = 0; idx < 18; idx++) {
      this.data[idx] = new JumpGalaxyShip();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_JUMPGALAXYSHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyId = b.readInt();
    this.dataLen = b.readByte();
    this.type = b.readByte();
    this.galaxyMapId = b.readByte();
    this.jumpType = b.readByte();
    for(int idx = 0; idx < 18; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyId);
    b.writeByte(this.dataLen);
    b.writeByte(this.type);
    b.writeByte(this.galaxyMapId);
    b.writeByte(this.jumpType);
    for(int idx = 0; idx < 18; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + JumpGalaxyShip.LENGTH * 18;
  }
  
  public void release() {
    for(int idx = 18 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
