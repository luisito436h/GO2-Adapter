package com.igg.go2.msg.fight;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_FORTRESSFIGHT</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class FortressFight extends MsgHead {
  public static final short LENGTH = 14 + MsgTypes.MAX_SHIPTEAMBODY * 6;
  
  public int objShipTeamId;
  public int objReduceSupply;
  public int objReduceStorage;
  public int[] objReduceHp;
  public short[] objReduceShipNum;
  public byte delFlag;
  public byte reserve;
  
  public FortressFight() {
    super();
    
    this.objReduceHp = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.objReduceShipNum = new short[MsgTypes.MAX_SHIPTEAMBODY];
    this.objShipTeamId = -1;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.objShipTeamId = b.readInt();
    this.objReduceSupply = b.readInt();
    this.objReduceStorage = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.objReduceHp[idx] = b.readInt();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.objReduceShipNum[idx] = b.readShort();
      }
    }
    this.delFlag = b.readByte();
    this.reserve = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    b.setPosition(0);
    
    b.writeShort(super.usSize);
    b.writeShort(super.usType);
    
    b.writeInt(this.objShipTeamId);
    b.writeInt(this.objReduceSupply);
    b.writeInt(this.objReduceStorage);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      b.writeInt(this.objReduceHp[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      b.writeShort(this.objReduceShipNum[idx]);
    }
    b.writeByte(this.delFlag);
    b.writeByte(this.reserve);
    
    b.padSize(super.usSize);
  }
  
  public void release() {
    this.objReduceHp = null;
    this.objReduceShipNum = null;
  }
}
