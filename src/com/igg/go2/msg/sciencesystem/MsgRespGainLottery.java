package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespGainLottery extends MsgHead {
  public int guid;
  public long userId;
  public String name;
  public int type;
  public int lotteryId;
  public int lotteryType;
  public int propsId;
  public int num;
  public int coins;
  public int metal;
  public int gas;
  public int money;
  public int broFlag;
  public int lockFlag;
  
  public MsgRespGainLottery() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GAINLOTTERY;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.type = b.readInt();
    this.lotteryId = b.readInt();
    this.lotteryType = b.readInt();
    this.propsId = b.readInt();
    this.num = b.readInt();
    this.coins = b.readInt();
    this.metal = b.readInt();
    this.gas = b.readInt();
    this.money = b.readInt();
    this.broFlag = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.guid);
    b.writeLong(this.userId);
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.type);
    b.writeInt(this.lotteryId);
    b.writeInt(this.lotteryType);
    b.writeInt(this.propsId);
    b.writeInt(this.num);
    b.writeInt(this.coins);
    b.writeInt(this.metal);
    b.writeInt(this.gas);
    b.writeInt(this.money);
    b.writeInt(this.broFlag);
    b.writeInt(this.lockFlag);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 60 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
