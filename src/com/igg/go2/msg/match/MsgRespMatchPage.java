/*
 * Used exclusively for quickly writing new Msg classes.
 * Do not fix errors. Remove before compile.
 */

package com.igg.go2.msg.match;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespMatchPage extends MsgHead {
  public int pageId;
  public int maxPageId;
  public int dataLen;
  public MatchPage[] data;
  
  public MsgRespMatchPage() {
    super();
    
    this.data = new MatchPage[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new MatchPage();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MATCHPAGE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.pageId = b.readInt();
    this.maxPageId = b.readInt();
    this.dataLen = b.readInt();
    for(int idx = 0; idx < 10; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.pageId);
    b.writeInt(this.maxPageId);
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MatchPage.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 10 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
