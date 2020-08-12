package com.igg.go2.msg.chiplottery;

import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CmosInfo {
  public static final short LENGTH = 8;

  public int usExp;
  public short propsId;
  public short reserve;

  public CmosInfo() {
    super();
    this.usExp = 0;
  }

  public void readBuf(ByteArray b) {
    this.usExp = b.readInt();
    this.propsId = b.readShort();
    this.reserve = b.readShort();
  }

  public void release() {
    //do nothing
  }
}