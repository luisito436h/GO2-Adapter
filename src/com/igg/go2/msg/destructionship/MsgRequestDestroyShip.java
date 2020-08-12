package com.igg.go2.msg.destructionship;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.ShipTeamNum;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestDestroyShip extends MsgHead {
  public int guid;
  public int dataLen;
  public ShipTeamNum[] data;
  
  public MsgRequestDestroyShip() {
    super();
    
    this.data = new ShipTeamNum[100];
    for(int idx = 0; idx < 100; idx++) {
      this.data[idx] = new ShipTeamNum();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_DESTROYSHIP;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    super.seqId = b.readInt();
    this.guid = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 100; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 100; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + ShipTeamNum.LENGTH * 100;
  }
  
  public void release() {
    for(int idx = 100 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
