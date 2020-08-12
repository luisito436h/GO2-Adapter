package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespConsortiaProclaim extends MsgHead {
  public int consortiaId;
  public long consortiaLeadUserId;
  public long cent;
  public int consortiaLeadGuid;
  public String consortiaLead;
  public String proclaim;
  public byte memberCount;
  public byte maxMemberCount;
  public byte consortiaLevel;
  public byte headId;
  public byte limitJoin;
  
  public MsgRespConsortiaProclaim() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAPROCLAIM;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaId = b.readInt();
    this.consortiaLeadUserId = b.readLong();
    this.cent = b.readLong();
    this.consortiaLeadGuid = b.readInt();
    this.consortiaLead = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.proclaim = b.readString(MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    this.memberCount = b.readByte();
    this.maxMemberCount = b.readByte();
    this.consortiaLevel = b.readByte();
    this.headId = b.readByte();
    this.limitJoin = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 33 + MsgTypes.MAX_NAME + MsgTypes.MAX_MEMO;
  }
  
  public void release() {
    //do nothing
  }
}
