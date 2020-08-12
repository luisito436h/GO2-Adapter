package com.igg.go2.common;

import net.skimnerphi.go2.util.ByteArray;

/**
 * Appears to represent message headers<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgHead {
  /**
   * Unsigned value representing message length.
   */
  public short usSize;
  /**
   * Unsigned value representing message type.
   */
  public short usType;
  /**
   * Value representing send order for Request-type messages
   */
  public int seqId;
  
  public MsgHead() {
    super();
  }
  
  public void readBuf(ByteArray b) {
    //do nothing
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  public short getLength() {
    return 0;
  }
  public short getLength(short param1) {
    return 0;
  }
  
  public void release() {
    //do nothing
  }
}
