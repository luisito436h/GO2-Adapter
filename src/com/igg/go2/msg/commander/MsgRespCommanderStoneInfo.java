package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCommanderStoneInfo extends MsgHead {
  public String userName;
  public String commanderZJ;
  public int exp;
  public int skillId;
  public int level;
  public int cardLevel;
  public int aim;
  public int blench;
  public int priority;
  public int electron;
  public int sAim;
  public int sBlench;
  public int sElectron;
  public int sPriority;
  public int sAssault;
  public int sEndure;
  public int sShield;
  public int sBlastHurt;
  public int sBlast;
  public int sDoubleHit;
  public int sRepairShield;
  public int sExp;
  public byte aimPer;
  public byte blenchPer;
  public byte priorityPer;
  public byte electronPer;
  public short[] cmos;
  
  public MsgRespCommanderStoneInfo() {
    super();
    
    this.cmos = new short[MsgTypes.MAX_COMMANDERCMOS];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERSTONEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.userName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.commanderZJ = b.readString(MsgTypes.COMMANDERZJCOUNT, ByteArray.CHARSET_UTF8);
    this.exp = b.readInt();
    this.skillId = b.readInt();
    this.level = b.readInt();
    this.cardLevel = b.readInt();
    this.aim = b.readInt();
    this.blench = b.readInt();
    this.priority = b.readInt();
    this.electron = b.readInt();
    this.sAim = b.readInt();
    this.sBlench = b.readInt();
    this.sElectron = b.readInt();
    this.sPriority = b.readInt();
    this.sAssault = b.readInt();
    this.sEndure = b.readInt();
    this.sShield = b.readInt();
    this.sBlastHurt = b.readInt();
    this.sBlast = b.readInt();
    this.sDoubleHit = b.readInt();
    this.sRepairShield = b.readInt();
    this.sExp = b.readInt();
    this.aimPer = b.readByte();
    this.blenchPer = b.readByte();
    this.priorityPer = b.readByte();
    this.electronPer = b.readByte();
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERCMOS; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.cmos[idx] = b.readShort();
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 88
         + MsgTypes.MAX_NAME
         + MsgTypes.COMMANDERZJCOUNT
         + MsgTypes.MAX_COMMANDERCMOS * 2;
  }
  
  public void release() {
    this.cmos = null;
  }
}
