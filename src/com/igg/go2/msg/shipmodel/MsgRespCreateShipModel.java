package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCreateShipModel extends MsgHead {
  public int shipModelId;
  public String shipName;
  public short bodyId;
  public short partNum;
  public short[] partId;
  public int needMoney;
  
  public MsgRespCreateShipModel() {
    super();
    
    this.partId = new short[MsgTypes.MAX_SHIPPART];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATESHIPMODEL;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.shipModelId = b.readInt();
    this.shipName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.bodyId = b.readShort();
    this.partNum = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPPART; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.partId[idx] = b.readShort();
      }
    }
    this.needMoney = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16
         + MsgTypes.MAX_NAME
         + MsgTypes.MAX_SHIPPART * 2;
  }
  
  public void release() {
    this.partId = null;
  }
}
