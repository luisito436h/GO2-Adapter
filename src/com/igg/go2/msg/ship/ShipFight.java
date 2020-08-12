package com.igg.go2.msg.ship;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_SHIPFIGHT</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipFight {
  public static final short LENGTH = 29
                                   + MsgTypes.MAX_SHIPTEAMBODY * 6
                                   + MsgTypes.MAX_MSG_PART * 7;
  
  public int srcReduceSupply;
  public int objReduceSupply;
  public int srcReduceStorage;
  public int objReduceStorage;
  public int srcReduceHp;
  public int[] objReduceShield;
  public int objReduceEndure;
  public short srcReduceShipNum;
  public short[] objReduceShipNum;
  public short[] srcPartId;
  public byte[] srcPartNum;
  public byte[] srcPartRate;
  public short[] objPartId;
  public byte[] objPartNum;
  public byte srcSkill;
  public byte objSkill;
  public byte objBlast;
  
  public ShipFight() {
    super();
    
    /*
     * MAX_SHIPTEAMBODY and MAX_MSG_PART were declared in-class in source
     * but since the same values are already in MsgTypes, using those instead.
    */
    
    this.objReduceShield = new int[MsgTypes.MAX_SHIPTEAMBODY];
    this.objReduceShipNum = new short[MsgTypes.MAX_SHIPTEAMBODY];
    this.srcPartId = new short[MsgTypes.MAX_MSG_PART];
    this.srcPartNum = new byte[MsgTypes.MAX_MSG_PART];
    this.srcPartRate = new byte[MsgTypes.MAX_MSG_PART];
    this.objPartId = new short[MsgTypes.MAX_MSG_PART];
    this.objPartNum = new byte[MsgTypes.MAX_MSG_PART];
  }
  
  public void readBuf(ByteArray b) {
    this.srcReduceSupply = b.readInt();
    this.objReduceSupply = b.readInt();
    this.srcReduceStorage = b.readInt();
    this.objReduceStorage = b.readInt();
    this.srcReduceHp = b.readInt();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 4) {
        this.objReduceShield[idx] = b.readInt();
      }
    }
    this.objReduceEndure = b.readInt();
    this.srcReduceShipNum = b.readShort();
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.objReduceShipNum[idx] = b.readShort();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.srcPartId[idx] = b.readShort();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      if(b.sizeRemaining() >= 1) {
        this.srcPartNum[idx] = b.readByte();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      if(b.sizeRemaining() >= 1) {
        this.srcPartRate[idx] = b.readByte();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      if(b.sizeRemaining() >= 2) {
        this.objPartId[idx] = b.readShort();
      }
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      if(b.sizeRemaining() >= 1) {
        this.objPartNum[idx] = b.readByte();
      }
    }
    this.srcSkill = b.readByte();
    this.objSkill = b.readByte();
    this.objBlast = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.srcReduceSupply);
    b.writeInt(this.objReduceSupply);
    b.writeInt(this.srcReduceStorage);
    b.writeInt(this.objReduceStorage);
    b.writeInt(this.srcReduceHp);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      b.writeInt(this.objReduceShield[idx]);
    }
    b.writeInt(this.objReduceEndure);
    b.writeShort(this.srcReduceShipNum);
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      b.writeShort(this.objReduceShipNum[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      b.writeShort(this.srcPartId[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      b.writeByte(this.srcPartNum[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      b.writeByte(this.srcPartRate[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      b.writeShort(this.objPartId[idx]);
    }
    for(int idx = 0; idx < MsgTypes.MAX_MSG_PART; idx++) {
      b.writeByte(this.objPartNum[idx]);
    }
    b.writeByte(this.srcSkill);
    b.writeByte(this.objSkill);
    b.writeByte(this.objBlast);
  }
  
  public void release() {
     this.objReduceShield = null;
     this.objReduceShipNum = null;
     this.srcPartId = null;
     this.srcPartNum = null;
     this.srcPartRate = null;
     this.objPartId = null;
     this.objPartNum = null;
  }
}
