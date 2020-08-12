package com.igg.go2.msg.fleet;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_SHIPTEAM_BODY</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class ShipTeamBody {
  public static final short LENGTH = 12;
  
  public int shipModelId;
  public int bodyId;
  public int num;
  
  public ShipTeamBody() {
    super();
    
    this.shipModelId = -1;
  }
  
  public void readBuf(ByteArray b) {
    this.shipModelId = b.readInt();
    this.bodyId = b.readInt();
    this.num = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.shipModelId);
    b.writeInt(this.bodyId);
    b.writeInt(this.num);
  }
  
  public void release() {
     //do nothing
  }
}
