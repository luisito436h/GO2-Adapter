package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_CONSORTIARANK_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ConsortiaRank {
  public static final short LENGTH = 20
                                   + MsgTypes.MAX_NAME
                                   + MsgTypes.MAX_CONSORTIAFIELD * 4;
  
  public String name;
  public int consortiaId;
  public int rankId;
  public int throwWealth;
  public int[] holdGalaxyArea;
  public short reserve0;
  public byte headId;
  public byte level;
  public byte holdGalaxy;
  public byte member;
  public byte maxMember;
  public byte reserve1;
  
  public ConsortiaRank() {
    super();
    this.holdGalaxyArea = new int[MsgTypes.MAX_CONSORTIAFIELD];
  }
  
  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortiaId = b.readInt();
    this.rankId = b.readInt();
    this.throwWealth = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_CONSORTIAFIELD; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.holdGalaxyArea[idx] = b.readInt();
      }
    }
    this.reserve0 = b.readShort();
    this.headId = b.readByte();
    this.level = b.readByte();
    this.holdGalaxy = b.readByte();
    this.member = b.readByte();
    this.maxMember = b.readByte();
    this.reserve1 = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeInt(this.consortiaId);
    b.writeInt(this.rankId);
    b.writeInt(this.throwWealth);
    for(int idx = 0; idx < MsgTypes.MAX_CONSORTIAFIELD; idx++) {
      b.writeInt(this.holdGalaxyArea[idx]);
    }
    b.writeShort(this.reserve0);
    b.writeByte(this.headId);
    b.writeByte(this.level);
    b.writeByte(this.holdGalaxy);
    b.writeByte(this.member);
    b.writeByte(this.maxMember);
    b.writeByte(this.reserve1);
  }
  
  public void release() {
     this.holdGalaxyArea = null;
  }
}
