package com.igg.go2.msg.gymkhana;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_RACINGINFOSHIPTEAM_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class RacingInfoShipTeam {
  public static final short LENGTH = 12 + MsgTypes.MAX_NAME;
  
  public String teamName;
  public int shipTeamId;
  public int commanderId;
  public short bodyId;
  public short shipNum;
  
  public RacingInfoShipTeam() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.teamName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.shipTeamId = b.readInt();
    this.commanderId = b.readInt();
    this.bodyId = b.readShort();
    this.shipNum = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.teamName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.shipTeamId);
    b.writeInt(this.commanderId);
    b.writeShort(this.bodyId);
    b.writeShort(this.shipNum);
  }
  
  public void release() {
     //do nothing
  }
}
