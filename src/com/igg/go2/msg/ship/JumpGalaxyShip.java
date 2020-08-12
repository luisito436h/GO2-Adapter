package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_JUMPGALAXYSHIP_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class JumpGalaxyShip {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME;
  
  public String teamName;
  public int shipTeamId;
  public int jumpNeedTime;
  public int shipNum;
  public int gas;
  public int commanderId;
  public short bodyId;
  public short gasPercent;
  
  public JumpGalaxyShip() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.teamName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.shipTeamId = b.readInt();
    this.jumpNeedTime = b.readInt();
    this.shipNum = b.readInt();
    this.gas = b.readInt();
    this.commanderId = b.readInt();
    this.bodyId = b.readShort();
    this.gasPercent = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.teamName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.shipTeamId);
    b.writeInt(this.jumpNeedTime);
    b.writeInt(this.shipNum);
    b.writeInt(this.gas);
    b.writeInt(this.commanderId);
    b.writeShort(this.bodyId);
    b.writeShort(this.gasPercent);
  }
  
  public void release() {
     //do nothing
  }
}
