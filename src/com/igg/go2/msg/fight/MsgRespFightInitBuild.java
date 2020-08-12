package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFightInitBuild extends MsgHead {
  public static final int MAX_INITBUILDNUM = 80;
  
  public int galaxyId;
  public short galaxyMapId;
  public short dataLen;
  public FightInitBuild[] data;
  
  public MsgRespFightInitBuild() {
    super();
    
    this.data = new FightInitBuild[MAX_INITBUILDNUM];
    for(int idx = 0; idx < MAX_INITBUILDNUM; idx++) {
      this.data[idx] = new FightInitBuild();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIGHTINIT_BUILD;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyId = b.readInt();
    this.galaxyMapId = b.readShort();
    this.dataLen = b.readShort();
    for(int idx = 0; idx < MAX_INITBUILDNUM; idx++) {
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
    b.writeShort(this.galaxyMapId);
    b.writeShort(this.dataLen);
    for(int idx = 0; idx < MAX_INITBUILDNUM; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + MAX_INITBUILDNUM * FightInitBuild.LENGTH;
  }
  
  public void release() {
    for(int idx = MAX_INITBUILDNUM - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
