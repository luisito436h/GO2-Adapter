package com.igg.go2.msg.galaxymap;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespGalaxyInfo extends MsgHead {
  public int objGuid;
  public long objUserId;
  public int galaxyMapId;
  public int galaxyId;
  public String name;
  public String consortia;
  public byte type;
  public byte level;
  public byte status;
  
  public MsgRespGalaxyInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_GALAXYINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.objGuid = b.readInt();
    this.objUserId = b.readLong();
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.consortia = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.type = b.readByte();
    this.level = b.readByte();
    this.status = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 27 + MsgTypes.MAX_NAME * 2;
  }
  
  public void release() {
    //do nothing
  }
}
