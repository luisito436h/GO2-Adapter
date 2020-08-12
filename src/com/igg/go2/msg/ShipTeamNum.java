package com.igg.go2.msg;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_SHIPTEAM_NUM</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipTeamNum {
  public static final short LENGTH = 8;

  public int shipModelId;
  public int num;

  public ShipTeamNum() {
    super();
    this.shipModelId = -1;
    this.num = 0;
  }

  public void readBuf(ByteArray b) {
    this.shipModelId = b.readInt();
    this.num = b.readInt();
  }

  public void writeBuf(ByteArray b) {
    b.writeInt(this.shipModelId);
    b.writeInt(this.num);
  }

  public void release() {
    //do nothing
  }
}