package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespInsertFlagConsortiaMember extends MsgHead {
  public String name;
  public int throwWealth;
  public int[] holdGalaxyArea;
  public byte headId;
  public byte level;
  public byte holdGalaxy;
  public byte memberCount;
  public int dataLen;
  public InsertFlagMember[] data;
  
  public MsgRespInsertFlagConsortiaMember() {
    super();
    
    this.holdGalaxyArea = new int[10];
    this.data = new InsertFlagMember[10];
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx] = new InsertFlagMember();
    }
    
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_INSERTFLAGCONSORTIAIMEMBER;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.throwWealth = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_CONSORTIAFIELD; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.holdGalaxyArea[idx] = b.readInt();
      }
    }
    this.headId = b.readByte();
    this.level = b.readByte();
    this.holdGalaxy = b.readByte();
    this.memberCount = b.readByte();
    this.dataLen = b.readInt();
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
    return 16
         + MsgTypes.MAX_NAME
         + MsgTypes.MAX_CONSORTIAFIELD + 4
         + InsertFlagMember.LENGTH * 10;
  }
  
  public void release() {
    for(int idx = 0; idx < 10; idx++) {
      this.data[idx].release();
    }
    this.holdGalaxyArea = null;
    this.data = null;
  }
}
