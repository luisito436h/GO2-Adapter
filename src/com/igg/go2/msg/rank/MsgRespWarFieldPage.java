package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespWarFieldPage extends MsgHead {
  public short pageId;
  public short pageNum;
  public WarFieldPage[] data;
  
  public MsgRespWarFieldPage() {
    super();
    
    this.data = new WarFieldPage[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new WarFieldPage();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_WARFIELD_PAGE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.pageId = b.readShort();
    this.pageNum = b.readShort();
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
    return 8 + WarFieldPage.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 10 - 1; idx >= 0; idx--) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
