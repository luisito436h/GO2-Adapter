package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespRacingRank extends MsgHead {
  public int userCount;
  public long userId;
  public int pageId;
  public int dataLen;
  public RacingRank[] data;
  
  public MsgRespRacingRank() {
    super();
    
    this.data = new RacingRank[6];
    for(int idx = 0; idx < 6; idx++) {
      this.data[idx] = new RacingRank();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_RACINGRANK;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.userCount = b.readInt();
    this.userId = b.readLong();
    this.pageId = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 6; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.userCount);
    b.writeLong(this.userId);
    b.writeInt(this.pageId);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 6; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24 + RacingRank.LENGTH * 6;
  }
  
  public void release() {
    for(int idx = 6 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
