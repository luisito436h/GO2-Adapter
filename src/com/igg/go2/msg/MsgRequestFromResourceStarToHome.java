package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestFromResourceStarToHome extends MsgHead {
  public int guid;
  public int galaxyMapId;
  public int galaxyId;
  public int shipTeamId;
  
  public MsgRequestFromResourceStarToHome() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_FROMRESOURCESTARTOHOME;
  }
  @Override
  public void readBuf(ByteArray b) {
    //do nothing
  }
  @Override
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
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 24;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
