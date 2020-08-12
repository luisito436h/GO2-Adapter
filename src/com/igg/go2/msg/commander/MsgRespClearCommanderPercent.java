package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespClearCommanderPercent extends MsgHead {
  public int commanderId;
  public int level;
  public int exp;
  public short aim;
  public short blench;
  public short priority;
  public short electron;
  public int lockFlag;
  public byte aimPer;
  public byte blenchPer;
  public byte priorityPer;
  public byte electronPer;
  
  public MsgRespClearCommanderPercent() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CLEARCOMMANDERPERCENT;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.commanderId = b.readInt();
    this.level = b.readInt();
    this.exp = b.readInt();
    this.aim = b.readShort();
    this.blench = b.readShort();
    this.priority = b.readShort();
    this.electron = b.readShort();
    this.lockFlag = b.readInt();
    this.aimPer = b.readByte();
    this.blenchPer = b.readByte();
    this.priorityPer = b.readByte();
    this.electronPer = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.commanderId);
    b.writeInt(this.level);
    b.writeInt(this.exp);
    b.writeShort(this.aim);
    b.writeShort(this.blench);
    b.writeShort(this.priority);
    b.writeShort(this.electron);
    b.writeInt(this.lockFlag);
    b.writeByte(this.aimPer);
    b.writeByte(this.blenchPer);
    b.writeByte(this.priorityPer);
    b.writeByte(this.electronPer);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 32;
  }
  
  public void release() {
    //do nothing
  }
}
