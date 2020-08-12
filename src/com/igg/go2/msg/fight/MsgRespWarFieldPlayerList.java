package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespWarFieldPlayerList extends MsgHead {
  public byte roomId;
  public byte reserve;
  public byte dataLen;
  public byte attackerNum;
  public WarfieldPlayer[] data;
  
  public MsgRespWarFieldPlayerList() {
    super();
    
    this.data = new WarfieldPlayer[50];
    for(int idx = 0; idx < 50; idx++) {
      this.data[idx] = new WarfieldPlayer();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_WARFIELD_PLAYERLIST;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.roomId = b.readByte();
    this.reserve = b.readByte();
    this.dataLen = b.readByte();
    this.attackerNum = b.readByte();
    for(int idx = 0; idx < 50; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
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
    return 8 + WarfieldPlayer.LENGTH * 50;
  }
  
  public void release() {
    for(int idx = 50 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
