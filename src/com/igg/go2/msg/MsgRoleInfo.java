package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRoleInfo extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int consortiaId;
  public int propsPack;
  public int propsCorpsPack;
  public byte consortiaJob;
  public byte consortiaUnionLevel;
  public byte consortiaShopLevel;
  public byte gameServerId;
  public int commander_Card;
  public int commander_Credit;
  public int commander_Card2;
  public int commander_Card3;
  public int commander_CardUnion;
  public int chargeFlag;
  public int addPackMoney;
  public int lotteryCredit;
  public int shipSpeedCredit;
  public int lotteryStatus;
  public int consortiaThrowValue;
  public int consortiaUnionValue;
  public int consortiaShopValue;
  public String name;
  public int defyEctypeNum;
  public int badge;
  public int honor;
  public int serverTime;
  public int tollGate;
  public short year;
  public byte month;
  public byte day;
  public int noviceGuide;
  public int warScoreExchange;
  
  public MsgRoleInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_ROLE_INFO;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.consortiaId = b.readInt();
    this.propsPack = b.readInt();
    this.propsCorpsPack = b.readInt();
    this.consortiaJob = b.readByte();
    this.consortiaUnionLevel = b.readByte();
    this.consortiaShopLevel = b.readByte();
    this.gameServerId = b.readByte();
    this.commander_Card = b.readInt();
    this.commander_Credit = b.readInt();
    this.commander_Card2 = b.readInt();
    this.commander_Card3 = b.readInt();
    this.commander_CardUnion = b.readInt();
    this.chargeFlag = b.readInt();
    this.addPackMoney = b.readInt();
    this.lotteryCredit = b.readInt();
    this.shipSpeedCredit = b.readInt();
    this.lotteryStatus = b.readInt();
    this.consortiaThrowValue = b.readInt();
    this.consortiaUnionValue = b.readInt();
    this.consortiaShopValue = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.defyEctypeNum = b.readInt();
    this.badge = b.readInt();
    this.honor = b.readInt();
    this.serverTime = b.readInt();
    this.tollGate = b.readInt();
    this.year = b.readShort();
    this.month = b.readByte();
    this.day = b.readByte();
    this.noviceGuide = b.readInt();
    this.warScoreExchange = b.readInt();
  }
  @Override
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 112 + MsgTypes.MAX_NAME;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
