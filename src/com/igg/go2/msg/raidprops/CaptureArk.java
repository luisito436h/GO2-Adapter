package com.igg.go2.msg.raidprops;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <codeMSG_RESP_CAPTURE_ARK_TMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CaptureArk {
  public static final short LENGTH = 8;
  
  public short rightPropsId;
  public short leftPropsId;
  public short countdown;
  public byte roomState;
  public byte roomId;
  
  public CaptureArk() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    this.rightPropsId = b.readShort();
    this.leftPropsId = b.readShort();
    this.countdown = b.readShort();
    this.roomState = b.readByte();
    this.roomId = b.readByte();
  }
  
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public void release() {
     //do nothing
  }
}
