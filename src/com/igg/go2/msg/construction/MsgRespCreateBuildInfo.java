package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCreateBuildInfo extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public int dataLen;
  public CreateBuildInfo[] data;
  
  public MsgRespCreateBuildInfo() {
    super();
    
    this.data = new CreateBuildInfo[20];
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx] = new CreateBuildInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CREATEBUILDINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 20; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 20; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + CreateBuildInfo.LENGTH * 20;
  }
  
  public void release() {
    for(int idx = 20 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
