package com.igg.go2.msg.shipmodel;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_SHIPMODELINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipModelInfo {
  public static final short LENGTH = 8
                                   + MsgTypes.MAX_NAME
                                   + MsgTypes.MAX_SHIPPART * 2;
  
  public String shipName;
  public byte partNum;
  public byte pubFlag;
  public short bodyId;
  public short[] partId;
  public int shipModelId;
  
  public ShipModelInfo() {
    super();
    
    this.partId = new short[MsgTypes.MAX_SHIPPART];
  }
  
  public void readBuf(ByteArray b) {
    b.setPosition(b.getPosition() + (4 - b.getPosition() % 4) % 4);
    this.shipName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.partNum = b.readByte();
    this.pubFlag = b.readByte();
    this.bodyId = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPPART; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.partId[idx] = b.readShort();
      }
    }
    this.shipModelId = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     this.partId = null;
  }
}
