package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespConsortiaMyself extends MsgHead {
  public int consortiaId;
  public long consortiaLeadUserId;
  public long cent;
  public String name;
  public String notice;
  public String proclaim;
  public String consortiaLead;
  public ConsortiaJobName jobName;
  public int consortiaGuid;
  public int sortId;
  public int wealth;
  public int repairWealth;
  public byte memberCount;
  public byte maxMemberCount;
  public byte headId;
  public byte level;
  public byte holdGalaxy;
  public byte maxHoldGalaxy;
  public byte storageLevel;
  public byte unionLevel;
  public int myWealth;
  public int upgradeTime;
  public byte upgradeType;
  public byte piratePassLevel;
  public byte attackUserLevel;
  public byte pirateNum;
  public String attackUser;
  public int attackUserGalaxyId;
  public int attackUserAssault;
  
  public MsgRespConsortiaMyself() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAMYSELF;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.consortiaId = b.readInt();
    this.consortiaLeadUserId = b.readLong();
    this.cent = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.notice = b.readString(MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    this.proclaim = b.readString(MsgTypes.MAX_MEMO, ByteArray.CHARSET_UTF8);
    this.consortiaLead = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.jobName.readBuf(b);
    this.consortiaGuid = b.readInt();
    this.sortId = b.readInt();
    this.wealth = b.readInt();
    this.repairWealth = b.readInt();
    this.memberCount = b.readByte();
    this.maxMemberCount = b.readByte();
    this.headId = b.readByte();
    this.level = b.readByte();
    this.holdGalaxy = b.readByte();
    this.maxHoldGalaxy = b.readByte();
    this.storageLevel = b.readByte();
    this.unionLevel = b.readByte();
    this.myWealth = b.readInt();
    this.upgradeTime = b.readInt();
    this.upgradeType = b.readByte();
    this.piratePassLevel = b.readByte();
    this.attackUserLevel = b.readByte();
    this.pirateNum = b.readByte();
    this.attackUser = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.attackUserGalaxyId = b.readInt();
    this.attackUserAssault = b.readInt();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return getLength((short)0);
  }
  public short getLength(short param1) {
    return 68
         + MsgTypes.MAX_NAME * 2
         + MsgTypes.MAX_MEMO * 2
         + ConsortiaJobName.LENGTH;
  }
  
  public void release() {
    this.jobName.release();
  }
}
