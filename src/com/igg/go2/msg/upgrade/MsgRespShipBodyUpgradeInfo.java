package com.igg.go2.msg.upgrade;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespShipBodyUpgradeInfo extends MsgHead {
  public int incUpgradePercent;
  public short bodyNum;
  public short partNum;
  public ShipBodyInfo[] bodyId;
  public ShipBodyInfo[] partId;
  
  public MsgRespShipBodyUpgradeInfo() {
    super();
    
    this.bodyId = new ShipBodyInfo[MsgTypes.MAX_SHIPBODYUPGRADELIST];
    this.partId = new ShipBodyInfo[MsgTypes.MAX_SHIPBODYUPGRADELIST];
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPBODYUPGRADELIST; idx++) {
      this.bodyId[idx] = new ShipBodyInfo();
      this.partId[idx] = new ShipBodyInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_SHIPBODYUPGRADEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.incUpgradePercent = b.readInt();
    this.bodyNum = b.readShort();
    this.partNum = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPBODYUPGRADELIST; idx++) {
      if(b.size() > b.getPosition()) {
        this.bodyId[idx].readBuf(b);
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPBODYUPGRADELIST; idx++) {
      if(b.size() > b.getPosition()) {
        this.partId[idx].readBuf(b);
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
    
    return 12 + MsgTypes.MAX_SHIPBODYUPGRADELIST * 2 * ShipBodyInfo.LENGTH;
  }
  
  public void release() {
    /*
     * Not technically how getLength is implemented in source but is faster, saner, and gives the same result.
    */
    for(int idx = MsgTypes.MAX_SHIPBODYUPGRADELIST - 1; idx >= 0; idx--) {
      this.bodyId[idx].release();
      this.partId[idx].release();
    }
    this.bodyId = null;
    this.partId = null;
  }
}
