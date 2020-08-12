package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespUseProps extends MsgHead {
  public int propsId;
  public byte lockFlag;
  public byte errorCode;
  public byte awardFlag;
  public byte awardLockFlag;
  public int awardGas;
  public int awardMoney;
  public int awardMetal;
  public int awardPropsLen;
  public int[] awardPropsId;
  public int[] awardPropsNum;
  public int moveHomeFlag;
  public int toGalaxyMapId;
  public int toGalaxyId;
  public int num;
  public int spValue;
  public int awardCoins;
  public int awardBadge;
  public int awardHonor;
  public int awardActiveCredit;
  public int pirateMoney;
  
  public MsgRespUseProps() {
    super();
    
    this.awardPropsId = new int[10];
    this.awardPropsNum = new int[10];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_USEPROPS;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.propsId = b.readInt();
    this.lockFlag = b.readByte();
    this.errorCode = b.readByte();
    this.awardFlag = b.readByte();
    this.awardLockFlag = b.readByte();
    this.awardGas = b.readInt();
    this.awardMoney = b.readInt();
    this.awardMetal = b.readInt();
    this.awardPropsLen = b.readInt();
    for(int idx = 0; idx < 10; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.awardPropsId[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < 10; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.awardPropsNum[idx] = b.readInt();
      }
    }
    this.moveHomeFlag = b.readInt();
    this.toGalaxyMapId = b.readInt();
    this.toGalaxyId = b.readInt();
    this.num = b.readInt();
    this.spValue = b.readInt();
    this.awardCoins = b.readInt();
    this.awardBadge = b.readInt();
    this.awardHonor = b.readInt();
    this.awardActiveCredit = b.readInt();
    this.pirateMoney = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 148;
  }
  
  public void release() {
    this.awardPropsId = null;
    this.awardPropsNum = null;
  }
}
