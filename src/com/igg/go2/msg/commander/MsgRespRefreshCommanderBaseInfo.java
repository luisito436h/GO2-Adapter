package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespRefreshCommanderBaseInfo extends MsgHead {
  public int dataLen;
  public RefreshCommanderBaseInfo[] data;
  
  public MsgRespRefreshCommanderBaseInfo() {
    super();
    
    this.data = new RefreshCommanderBaseInfo[MsgTypes.MAX_COMMANDERNUM];
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      this.data[idx] = new RefreshCommanderBaseInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_REFRESHCOMMANDERBASEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.dataLen);
    for(int idx = 0; idx < MsgTypes.MAX_COMMANDERNUM; idx++) {
      this.data[idx].writeBuf(b);
    }
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    /*
     * Not technically how getLength is implemented in source but is faster, saner, and gives the same result.
    */
    return 8 + MsgTypes.MAX_COMMANDERNUM * RefreshCommanderBaseInfo.LENGTH;
  }
  
  public void release() {
    for(int idx = MsgTypes.MAX_COMMANDERNUM - 1; idx >= 0; idx++) {
      this.data[idx].release();
    }
    this.data = null;
  }
}
