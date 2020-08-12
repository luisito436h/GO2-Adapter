package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespMoveHomeBro extends MsgHead {
  public int delGalaxy;
  public PlanetInfo data;
  
  public MsgRespMoveHomeBro() {
    super();
    
    this.data = new PlanetInfo();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MOVEHOMEBRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.delGalaxy = b.readInt();
    this.data.readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.delGalaxy);
    this.data.writeBuf(b);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + PlanetInfo.LENGTH;
  }
  
  public void release() {
    this.data.release();
  }
}
