package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespPlayerResource extends MsgHead {
  public int userGas;
  public int userMetal;
  public int userMoney;
  public int credit;
  public int level;
  public int exp;
  public int coins;
  public int outGas;
  public int outMetal;
  public int outMoney;
  public int maxSpValue;
  public int spValue;
  public int moneyBuyNum;
  public int defyEctypeNum;
  public int matchCount;
  public int tollGate;
  public int reserve;
  
  public MsgRespPlayerResource() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_PLAYERRESOURCE;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.userGas = b.readInt();
    this.userMetal = b.readInt();
    this.userMoney = b.readInt();
    this.credit = b.readInt();
    this.level = b.readInt();
    this.exp = b.readInt();
    this.coins = b.readInt();
    this.outGas = b.readInt();
    this.outMetal = b.readInt();
    this.outMoney = b.readInt();
    this.maxSpValue = b.readInt();
    this.spValue = b.readInt();
    this.moneyBuyNum = b.readInt();
    this.defyEctypeNum = b.readInt();
    this.matchCount = b.readInt();
    this.tollGate = b.readInt();
    this.reserve = b.readInt();
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
    return 72;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
