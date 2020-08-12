package com.igg.go2.msg.field;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespFieldResource extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int consortiaPer;
  public byte friendFlag;
  public byte fieldCenterStatus;
  public byte techPerMetal;
  public byte techPerGas;
  public byte techPerMoney;
  public byte propsPerMetal;
  public byte propsPerGas;
  public byte propsPerMoney;
  public FieldResource[] data;
  public int fieldCenterTime;
  public int[] helpGuid;
  
  public MsgRespFieldResource() {
    super();
    
    this.data = new FieldResource[MsgTypes.MAX_FIELDRESOURCE];
    this.helpGuid = new int[MsgTypes.MAX_HELPCOUNT];
    for(int idx = 0; idx < MsgTypes.MAX_FIELDRESOURCE; idx++) {
      this.data[idx] = new FieldResource();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_FIELDRESOURCE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.consortiaPer = b.readInt();
    this.friendFlag = b.readByte();
    this.fieldCenterStatus = b.readByte();
    this.techPerMetal = b.readByte();
    this.techPerGas = b.readByte();
    this.techPerMoney = b.readByte();
    this.propsPerMetal = b.readByte();
    this.propsPerGas = b.readByte();
    this.propsPerMoney = b.readByte();
    for(int idx = 0; idx < MsgTypes.MAX_FIELDRESOURCE; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
    this.fieldCenterTime = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_HELPCOUNT; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.helpGuid[idx] = b.readInt();
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
    return 28
         + MsgTypes.MAX_FIELDRESOURCE * FieldResource.LENGTH
         + MsgTypes.MAX_HELPCOUNT * 4;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_FIELDRESOURCE - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
    this.helpGuid = null;
  }
}
