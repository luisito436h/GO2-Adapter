package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespMoveHome extends MsgHead {
  public String consortiaName;
  public int toGalaxyMapId;
  public int toGalaxyId;
  public int errorCode;
  public int propsId;
  public int lockFlag;
  
  public MsgRespMoveHome() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_MOVEHOME;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaName = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.toGalaxyMapId = b.readInt();
    this.toGalaxyId = b.readInt();
    this.errorCode = b.readInt();
    this.propsId = b.readInt();
    this.lockFlag = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 24 + MsgTypes.MAX_NAME;
  }
  
  public void release() {
    //do nothing
  }
}
