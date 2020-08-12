package com.igg.go2.msg.chiplottery;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespGainCmosLottery extends MsgHead {
  public int guid;
  public int lotteryId;
  public int propsId;
  public int type;
  public int credit;
  public int lotteryPhase;
  public byte broFlag;
  public String name;
  
  public MsgRespGainCmosLottery() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GAINCMOSLOTTERY;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.lotteryId = b.readInt();
    this.propsId = b.readInt();
    this.type = b.readInt();
    this.credit = b.readInt();
    this.lotteryPhase = b.readInt();
    this.broFlag = b.readByte();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 26 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
