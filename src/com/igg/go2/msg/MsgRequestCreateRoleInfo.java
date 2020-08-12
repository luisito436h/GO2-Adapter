package com.igg.go2.msg;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * This Class is not properly ported yet, for the source version is rather anomalous and doesn't seem to be referenced ever.<br/>
 * Creating a new instance of this will throw an Exception.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRequestCreateRoleInfo extends MsgHead {
  
  public MsgRequestCreateRoleInfo() {
    super();
    super.usSize = this.getLength();
    super.usType = MsgTypes.MSG_REQUEST_CREATEROLE;
    throw new UnsupportedOperationException("Attempted to call MsgRequestCreateRoleInfo(), but it isn't implemented yet.");
  }
  @Override
  public void readBuf(ByteArray b) {
    //do nothing
  }
  @Override
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  @Override
  public short getLength() {
    return getLength((short)0);
  }
  @Override
  public short getLength(short param1) {
    return 0;
  }
  
  @Override
  public void release() {
    //do nothing
  }
}
