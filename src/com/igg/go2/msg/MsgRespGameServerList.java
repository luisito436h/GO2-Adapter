package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespGameServerList extends MsgHead {
  public int guid;
  public int dataLen;
  public byte[] data;
  public int[] registerNum;
  public int[] onlineNum;
  
  public MsgRespGameServerList() {
    super();
    
    this.data = new byte[MsgTypes.MAX_GAMESERVERLIST];
    this.registerNum = new int[MsgTypes.MAX_GAMESERVERLIST];
    this.onlineNum = new int[MsgTypes.MAX_GAMESERVERLIST];
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GAMESERVERLIST;
  }
  @Override
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.guid = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      if(b.sizeRemaining() >= 1) {
        this.data[idx] = b.readByte();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.registerNum[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_GAMESERVERLIST; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.onlineNum[idx] = b.readInt();
      }
    }
  }
  @Override
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 12 + MsgTypes.MAX_GAMESERVERLIST * 9;
  }
  
  @Override
  public void release() {
    this.data = null;
    this.registerNum = null;
    this.onlineNum = null;
  }
}
