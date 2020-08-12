package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.galaxymap.HoldGalaxy;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgShipTeamHoldGalaxy extends MsgHead {
  public int dataLen;
  public HoldGalaxy[] data;
  
  public MsgShipTeamHoldGalaxy() {
    super();
    
    this.data = new HoldGalaxy[MsgTypes.MAX_USERSHIPTEAMNUM];
    for(int idx = 0; idx < MsgTypes.MAX_USERSHIPTEAMNUM; idx++) {
      this.data[idx] = new HoldGalaxy();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_SHIPTEAMHOLDGALAXY;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_USERSHIPTEAMNUM; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_USERSHIPTEAMNUM; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 8 + MsgTypes.MAX_USERSHIPTEAMNUM * HoldGalaxy.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_USERSHIPTEAMNUM - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
