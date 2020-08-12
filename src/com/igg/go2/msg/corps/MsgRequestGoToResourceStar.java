package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestGoToResourceStar extends MsgHead {
  public int guid;
  public int galaxyMapId;
  public int galaxyId;
  public int dataLen;
  public int[] shipTeamId;
  
  public MsgRequestGoToResourceStar() {
    super();
    
    this.shipTeamId = new int[100];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_GOTORESOURCESTAR;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 100; idx++) {
      b.writeInt(this.shipTeamId[idx]);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 424;
  }
  
  public void release() {
    this.shipTeamId = null;
  }
}
