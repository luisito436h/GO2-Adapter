package com.igg.go2.msg.match;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespMatchInfo extends MsgHead {
  public int spareTime;
  public int matchWeekTop;
  public short reserve;
  public byte matchWin;
  public byte matchLost;
  public byte matchDogfall;
  public byte matchLevel;
  public byte matchCount;
  public byte matchType;
  
  public MsgRespMatchInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MATCHINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.spareTime = b.readInt();
    this.matchWeekTop = b.readInt();
    this.reserve = b.readShort();
    this.matchWin = b.readByte();
    this.matchLost = b.readByte();
    this.matchDogfall = b.readByte();
    this.matchLevel = b.readByte();
    this.matchCount = b.readByte();
    this.matchType = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.spareTime);
    b.writeInt(this.matchWeekTop);
    b.writeShort(this.reserve);
    b.writeByte(this.matchWin);
    b.writeByte(this.matchLost);
    b.writeByte(this.matchDogfall);
    b.writeByte(this.matchLevel);
    b.writeByte(this.matchCount);
    b.writeByte(this.matchType);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
