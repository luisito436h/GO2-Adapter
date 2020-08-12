package com.igg.go2.msg.sciencesystem;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgRespPropsInfo extends MsgHead {
  public static int MAX_CONSORTIASTORAGE = 100;
  /*
   * This value seems a bit strange, as the max bag size is 200. Adjust if it causes problems.
   * Addendum: judging from how Props are structured, it appears that this indicates a maximum amount of 150
   * unique item ids, rather than 150 stacks (locked / unlocked are the same for this count).
   */
  public static int MAX_PRIVATESTORAGE = 150;
  
  public int dataLen;
  public Props[] data;
  
  public MsgRespPropsInfo() {
    super();
    
    this.data = new Props[MAX_CONSORTIASTORAGE + MAX_PRIVATESTORAGE];
    
    /*
     * The source doesn't calculate the length clientside, presumably because it would vary too much.
    */
    super.usType = MsgTypes.MSG_RESP_PROPSINFO;
  }
  public void readBuf(ByteArray b) {
    super.usSize = b.readShort();
    super.usType = b.readShort();
    
    this.dataLen = b.readInt();
    for(int idx = 0; idx < this.dataLen; idx++) {
      if(this.data[idx] == null) {
        this.data[idx] = new Props();
      }
      if(b.size() > b.getPosition()) {
        this.data[idx].readBuf(b);
      }
    }
  }
  public void writeBuf(ByteArray b) {
    //do nothing
  }
  
  /**
   * This particular <code>getLength()</code> only works as expected <i>after</i> <code>readBuf()</code> has been called, as the packet varies in length.
   */
  public short getLength() {
    return getLength((short)0);
  }
  /**
   * This particular <code>getLength()</code> only works as expected <i>after</i> <code>readBuf()</code> has been called, as the packet varies in length.
   */
  public short getLength(short param1) {
    return super.usSize;
  }
  
  public void release() {
    //do nothing
  }
}
