package com.igg.go2.msg.corps;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi using script
 * @author IGG
 */
public class MsgRespConsortiaUpgradeComplete extends MsgHead {
  public int type;
  public int consortiaId;
  public int propsCorpsPack;
  public byte level;
  public byte storageLevel;
  public byte unionLevel;
  public byte shopLevel;
  
  public MsgRespConsortiaUpgradeComplete() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_RESP_CONSORTIAUPGRADECOMPLETE;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.type = b.readInt();
    this.consortiaId = b.readInt();
    this.propsCorpsPack = b.readInt();
    this.level = b.readByte();
    this.storageLevel = b.readByte();
    this.unionLevel = b.readByte();
    this.shopLevel = b.readByte();
  }
  public void writeBuf(ByteArray b) {
    //do nothing
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
