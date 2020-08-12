package com.igg.go2.msg.loadhe3;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_LOADSHIPTEAMALL_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipTeamFuelInfo {
  public static final short LENGTH = 20 + MsgTypes.MAX_NAME;
  
  public String shipName;
  public int shipTeamId;
  public int shipNum;
  public int shipSpace;
  public int gas;
  public int supply;
  
  public ShipTeamFuelInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.shipName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.shipTeamId = b.readInt();
    this.shipNum = b.readInt();
    this.shipSpace = b.readInt();
    this.gas = b.readInt();
    this.supply = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
