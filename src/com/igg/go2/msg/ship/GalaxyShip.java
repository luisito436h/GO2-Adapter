package com.igg.go2.msg.ship;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_GALAXYSHIP_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class GalaxyShip {
  public static final short LENGTH = 16;
  
  public int shipTeamId;
  public int shipNum;
  public short bodyId;
  public short reserve;
  public byte direction;
  public byte posX;
  public byte posY;
  public byte owner;
  
  public GalaxyShip() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.shipTeamId = b.readInt();
    this.shipNum = b.readInt();
    this.bodyId = b.readShort();
    this.reserve = b.readShort();
    this.direction = b.readByte();
    this.posX = b.readByte();
    this.posY = b.readByte();
    this.owner = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
