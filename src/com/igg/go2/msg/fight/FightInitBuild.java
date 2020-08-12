package com.igg.go2.msg.fight;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FIGHTINIT_BUILD_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FightInitBuild {
  public static final short LENGTH = 12;
  
  public int maxEndure;
  public int endure;
  public short indexId;
  public byte headId;
  public byte reserve;
  
  public FightInitBuild() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.maxEndure = b.readInt();
    this.endure = b.readInt();
    this.indexId = b.readShort();
    this.headId = b.readByte();
    this.reserve = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.maxEndure);
    b.writeInt(this.endure);
    b.writeShort(this.indexId);
    b.writeByte(this.headId);
    b.writeByte(this.reserve);
  }
  
  public void release() {
     //do nothing
  }
}
