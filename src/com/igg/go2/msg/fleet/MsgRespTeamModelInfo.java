package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespTeamModelInfo extends MsgHead {
  public int dataLen;
  public TeamModel[] teamModel;
  
  public MsgRespTeamModelInfo() {
    super();
    
    /*
     * This array was accessed through loops in the source, but since it's
     * only 3 long, it's faster to simply hardcode it.
    */
    this.teamModel = new TeamModel[3];
    this.teamModel[0] = new TeamModel();
    this.teamModel[1] = new TeamModel();
    this.teamModel[2] = new TeamModel();
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_TEAMMODELINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    this.teamModel[0].readBuf(b);
    this.teamModel[1].readBuf(b);
    this.teamModel[2].readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + TeamModel.LENGTH * 3;
  }
  
  public void release() {
    this.teamModel[2].release();
    this.teamModel[1].release();
    this.teamModel[0].release();
    this.teamModel = null;
  }
}
