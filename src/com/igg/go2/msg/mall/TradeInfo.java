package com.igg.go2.msg.mall;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_TRADEINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class TradeInfo {
  public static final short LENGTH = 40 + MsgTypes.MAX_NAME;
  
  public long sellUserId;
  public String sellName;
  public int sellGuid;
  public int indexId;
  public int id;
  public int num;
  public int price;
  public int spareTime;
  public int reserve;
  public short bodyId;
  public byte tradeType;
  public byte priceType;
  
  public TradeInfo() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.sellUserId = b.readLong();
    this.sellName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.indexId = b.readInt();
    this.id = b.readInt();
    this.num = b.readInt();
    this.price = b.readInt();
    this.spareTime = b.readInt();
    this.reserve = b.readInt();
    this.bodyId = b.readShort();
    this.tradeType = b.readByte();
    this.priceType = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
