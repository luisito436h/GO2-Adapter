package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespArenaPage extends MsgHead {
  public short pageId;
  public short pageNum;
  public byte arenaFlag;
  public byte dataLen;
  public ArenaPage[] data;
  
  public MsgRespArenaPage() {
    super();
    
    this.data = new ArenaPage[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new ArenaPage();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_ARENA_PAGE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.pageId = b.readShort();
    this.pageNum = b.readShort();
    this.arenaFlag = b.readByte();
    this.dataLen = b.readByte();
    for(int idx = 0; idx < 10; idx++) {
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
    return 14 + ArenaPage.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 10 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
