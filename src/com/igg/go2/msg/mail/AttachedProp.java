package com.igg.go2.msg.mail;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_RESP_READEMAIL_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class AttachedProp {
  public static final short LENGTH = 12;
  
  public int id;
  public int num;
  public short lockNum;
  public short bodyId;
  
  public AttachedProp() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.id = b.readInt();
    this.num = b.readInt();
    this.lockNum = b.readShort();
    this.bodyId = b.readShort();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
