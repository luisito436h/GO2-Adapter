package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRequestInsertFlagConsortiaMember extends MsgHead {
  public int guid;
  public int consortiaId;
  public int pageId;
  
  public MsgRequestInsertFlagConsortiaMember() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_INSERTFLAGCONSORTIAIMEMBER;
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
    b.writeInt(this.consortiaId);
    b.writeInt(this.pageId);
    
    b.padSize(super.usSize);
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 20;
  }
  
  public void release() {
    //do nothing
  }
}
