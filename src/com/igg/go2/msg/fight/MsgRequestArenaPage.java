package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestArenaPage extends MsgHead {
  public int guid;
  public short pageId;
  public byte itemNum;
  public byte arenaFlag;
  public String cName;
  
  public MsgRequestArenaPage() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_ARENA_PAGE;
  }
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(super.seqId);
    b.writeInt(this.guid);
    b.writeShort(this.pageId);
    b.writeByte(this.itemNum);
    b.writeByte(this.arenaFlag);
    b.writeString(this.cName, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 16 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
