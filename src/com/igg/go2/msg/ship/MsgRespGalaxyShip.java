package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespGalaxyShip extends MsgHead {
  public short dataLen;
  public short galaxyMapId;
  public int galaxyId;
  public GalaxyShip[] data;
  
  public MsgRespGalaxyShip() {
    super();
    
    this.data = new GalaxyShip[MsgTypes.MAX_SENDTEAMINFO];
    
    /*
     * The source doesn't calculate the length clientside, presumably because it would vary too much.
    */
    super.usType = MsgTypes.MSG_RESP_GALAXYSHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readShort();
    this.galaxyMapId = b.readShort();
    this.galaxyId = b.readInt();
    for(int idx = 0; idx < this.dataLen; idx++) {
      if(this.data[idx] == null) {
        this.data[idx] = new GalaxyShip();
      }
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
    return 0;
  }
  
  public void release() {
    for(int idx = this.dataLen - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
