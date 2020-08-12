package com.igg.go2.msg.galaxymap;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_HOLDGALAXY_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class HoldGalaxy {
  public static final short LENGTH = 8;
  
  public int galaxyMapId;
  public int galaxyId;
  
  public HoldGalaxy() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.galaxyMapId = b.readInt();
    this.galaxyId = b.readInt();
  }
  
  public void writeBuf(ByteArray b) {
    b.writeInt(this.galaxyMapId);
    b.writeInt(this.galaxyId);
  }
  
  public void release() {
     //do nothing
  }
}
