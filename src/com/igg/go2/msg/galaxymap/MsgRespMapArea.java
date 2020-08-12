package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespMapArea extends MsgHead {
  public short regionId;
  public byte galaxyMapId;
  public byte dataLen;
  public PlanetInfo[] data;
  
  public MsgRespMapArea() {
    super();
    
    this.data = new PlanetInfo[25];
    for(int idx = 0; idx < 25; idx++) {
      this.data[idx] = new PlanetInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MAPAREA;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.regionId = b.readShort();
    this.galaxyMapId = b.readByte();
    this.dataLen = b.readByte();
    for(int idx = 0; idx < 25; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeShort(this.regionId);
    b.writeByte(this.galaxyMapId);
    b.writeByte(this.dataLen);
    for(int idx = 0; idx < 25; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + PlanetInfo.LENGTH * 25;
  }
  
  public void release() {
    for(int idx = 25 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
