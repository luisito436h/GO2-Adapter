package com.igg.go2.msg.rank;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_WARFIELD_PAGE_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class WarFieldPage {
  public static final short LENGTH = 22 + MsgTypes.MAX_NAME;
  
  public long userId;
  public String name;
  public int guid;
  public int warScore;
  public int warKilldown;
  public short warWin;
  
  public WarFieldPage() {
    super();
    
    this.guid = -1;
  }
  
  public void readBuf(ByteArray b) {
    this.userId = b.readLong();
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.guid = b.readInt();
    this.warScore = b.readInt();
    this.warKilldown = b.readInt();
    this.warWin = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
