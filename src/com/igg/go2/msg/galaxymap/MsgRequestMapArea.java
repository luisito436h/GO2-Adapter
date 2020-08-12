package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestMapArea extends MsgHead {
  public static final int CLIENTMAXLOADAREA = 16;
  
  public int guid;
  public int galaxyMapId;
  public int[] regionId;
  
  public MsgRequestMapArea() {
    super();
    
    this.regionId = new int[CLIENTMAXLOADAREA];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_MAPAREA;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.galaxyMapId = b.readInt();
    for(int idx = 0; idx < CLIENTMAXLOADAREA; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.regionId[idx] = b.readInt();
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyMapId);
    for(int idx = 0; idx < CLIENTMAXLOADAREA; idx++) {
      b.writeInt(this.regionId[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + CLIENTMAXLOADAREA * 4;
  }
  
  public void release() {
    this.regionId = null;
  }
}
