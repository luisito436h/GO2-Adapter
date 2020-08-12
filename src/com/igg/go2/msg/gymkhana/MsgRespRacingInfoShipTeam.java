package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespRacingInfoShipTeam extends MsgHead {
  public byte dataLen;
  public byte type;
  public RacingInfoShipTeam[] data;
  
  public MsgRespRacingInfoShipTeam() {
    super();
    
    this.data = new RacingInfoShipTeam[20];
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx] = new RacingInfoShipTeam();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_RACINGINFOSHIPTEAM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readByte();
    this.type = b.readByte();
    for(int idx = 0; idx < 20; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeByte(this.dataLen);
    b.writeByte(this.type);
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 6 + RacingInfoShipTeam.LENGTH * 20;
  }
  
  public void release() {
    for(int idx = 20 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
