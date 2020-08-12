package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespOperateConsortiaBro extends MsgHead {
  public int consortiaId;
  public int type;
  public int propsCorpsPack;
  public byte job;
  public byte unionLevel;
  public byte shopLevel;
  public byte reserve2;
  public int needUnionValue;
  public int needShopValue;
  
  public MsgRespOperateConsortiaBro() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_OPERATECONSORTIABRO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaId = b.readInt();
    this.type = b.readInt();
    this.propsCorpsPack = b.readInt();
    this.job = b.readByte();
    this.unionLevel = b.readByte();
    this.shopLevel = b.readByte();
    this.reserve2 = b.readByte();
    this.needUnionValue = b.readInt();
    this.needShopValue = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.consortiaId);
    b.writeInt(this.type);
    b.writeInt(this.propsCorpsPack);
    b.writeByte(this.job);
    b.writeByte(this.unionLevel);
    b.writeByte(this.shopLevel);
    b.writeByte(this.reserve2);
    b.writeInt(this.needUnionValue);
    b.writeInt(this.needShopValue);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 28;
  }
  
  public void release() {
    //do nothing
  }
}
