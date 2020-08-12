package com.igg.go2.msg.construction;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespBuildInfo extends MsgHead {
  public int galaxyMapId;
  public int galaxyId;
  public short consortiaLeader;
  public byte viewFlag;
  public byte starType;
  public int dataLen;
  public BuildInfo[] data;
  
  public MsgRespBuildInfo() {
    super();
    
    this.data = new BuildInfo[MsgTypes.MAX_BUILDING];
    for(int idx = 0; idx < MsgTypes.MAX_BUILDING; idx++) {
      this.data[idx] = new BuildInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_BUILDINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.consortiaLeader = b.readShort();
    this.viewFlag = b.readByte();
    this.starType = b.readByte();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_BUILDING; idx++) {
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
    b.writeShort(this.consortiaLeader);
    b.writeByte(this.viewFlag);
    b.writeByte(this.starType);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_BUILDING; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_BUILDING - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
