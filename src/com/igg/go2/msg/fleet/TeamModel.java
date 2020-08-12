package com.igg.go2.msg.fleet;

import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TeamModel {
  public static final short LENGTH = ShipTeamNum.LENGTH * MsgTypes.MAX_SHIPTEAMBODY;
  
  public ShipTeamNum[] model;
  
  public TeamModel() {
    super();
    
    this.model = new ShipTeamNum[MsgTypes.MAX_SHIPTEAMBODY];
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.model[idx] = new ShipTeamNum();
    }
  }
  
  public void readBuf(ByteArray b) {
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.model[idx].readBuf(b);
    }
  }
  
  public void writeBuf(ByteArray b) {
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      this.model[idx].writeBuf(b);
    }
  }
  
  public void release() {
     for(int idx = MsgTypes.MAX_SHIPTEAMBODY - 1; idx >= 0; idx--) {
       this.model[idx].release();
     }
     this.model = null;
  }
}
