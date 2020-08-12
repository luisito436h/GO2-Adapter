package com.igg.go2.msg.loadhe3;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespLoadShipTeamAll extends MsgHead {
  public int guid;
  public int dataLen;
  public ShipTeamFuelInfo[] data;
  
  public MsgRespLoadShipTeamAll() {
    super();
    
    this.data = new ShipTeamFuelInfo[19];
    for(int idx = 0; idx < 19; idx++) {
      this.data[idx] = new ShipTeamFuelInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_LOADSHIPTEAMALL;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 19; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + ShipTeamFuelInfo.LENGTH * 19;
  }
  
  public void release() {
    for(int idx = 19 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
