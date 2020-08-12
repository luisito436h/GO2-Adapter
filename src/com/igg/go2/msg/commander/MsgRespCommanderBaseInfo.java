package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespCommanderBaseInfo extends MsgHead {
  public int dataLen;
  public int nextInviteTime;
  public int reserve;
  public CommanderBaseInfo[] data;
  
  public MsgRespCommanderBaseInfo() {
    super();
    
    this.data = new CommanderBaseInfo[18];
    for(int idx = 0; idx < 18; idx++) {
      this.data[idx] = new CommanderBaseInfo();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_COMMANDERBASEINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    this.nextInviteTime = b.readInt();
    this.reserve = b.readInt();
    for(int idx = 0; idx < 18 ; idx++) {
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
    b.writeInt(this.nextInviteTime);
    b.writeInt(this.reserve);
    for(int idx = 0; idx < 18; idx++) {
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
    return 16 + CommanderBaseInfo.LENGTH * 18;
  }
  
  public void release() {
    //do nothing
  }
}
