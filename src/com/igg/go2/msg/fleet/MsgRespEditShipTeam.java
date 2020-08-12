package com.igg.go2.msg.fleet;

import com.igg.go2.msg.ship.GalaxyShip;
import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespEditShipTeam extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public GalaxyShip data;
  
  public MsgRespEditShipTeam() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_EDITSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.data.readBuf(b);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 12 + GalaxyShip.LENGTH;
  }
  
  public void release() {
    this.data.release();
  }
}
