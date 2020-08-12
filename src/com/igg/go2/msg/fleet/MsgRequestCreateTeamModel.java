package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCreateTeamModel extends MsgHead {
  public int guid;
  public int indexId;
  public int delFlag;
  public TeamModel teamModel;
  
  public MsgRequestCreateTeamModel() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATETEAMMODEL;
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
    b.writeInt(this.indexId);
    b.writeInt(this.delFlag);
    this.teamModel.writeBuf(b);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20 + TeamModel.LENGTH;
  }
  
  public void release() {
    this.teamModel.release();
  }
}
