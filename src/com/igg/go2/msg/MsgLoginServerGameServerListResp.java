package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgLoginServerGameServerListResp extends MsgHead {
  public int dataLen;
  public int defaultServerId;
  public int newServerId;
  public GameServerInfo[] data;
  
  public MsgLoginServerGameServerListResp() {
    super();
    
    this.data = new GameServerInfo[MsgTypes.MAX_GAMESERVERLIST];
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      this.data[idx] = new GameServerInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_LOGINSERVER_GAMESERVERLISTRESP;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    this.defaultServerId = b.readInt();
    this.newServerId = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].writeBuf(b);
      }
    }
  }
  @Override
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    b.writeInt(this.defaultServerId);
    b.writeInt(this.newServerId);
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 16 + GameServerInfo.LENGTH;
  }
  
  @Override
  public void release() {
    for(int idx = MsgTypes.MAX_GAMESERVERLIST - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
