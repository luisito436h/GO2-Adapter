/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.igg.go2.msg.commander;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_REFRESHCOMMANDERBASEINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RefreshCommanderBaseInfo {
  public static final short LENGTH = 20;
  
  public int commanderId;
  public int exp;
  public short aim;
  public short blench;
  public short priority;
  public short electron;
  public short reserve;
  public byte level;
  public byte reserve2;
  
  public RefreshCommanderBaseInfo() {
    super();
  }

  public void readBuf(ByteArray b) {
    b.setPosition((4 - b.getPosition() % 4) % 4);
    
    this.commanderId = b.readInt();
    this.exp = b.readInt();
    this.aim = b.readShort();
    this.blench = b.readShort();
    this.priority = b.readShort();
    this.electron = b.readShort();
    this.reserve = b.readShort();
    this.level = b.readByte();
    this.reserve2 = b.readByte();
  }

  public void writeBuf(ByteArray b) {
    b.pushByte((4 - b.size() % 4) % 4);

    b.writeInt(this.commanderId);
    b.writeInt(this.exp);
    b.writeShort(this.aim);
    b.writeShort(this.blench);
    b.writeShort(this.priority);
    b.writeShort(this.electron);
    b.writeShort(this.reserve);
    b.writeByte(this.level);
    b.writeByte(this.reserve2);
  }
  
  public void release() {
    //do nothing
  }
}
