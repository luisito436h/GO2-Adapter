package com.igg.go2.msg.commander;

import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_COMMANDERINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CommanderInfo {
  public static final short LENGTH = 8;

  public int commanderId;
  public int state;

  public CommanderInfo() {
    super();
  }

  public void readBuf(ByteArray b) {
    this.commanderId = b.readInt();
    this.state = b.readInt();
  }

  public void writeBuf(ByteArray b) {
    b.writeInt(this.commanderId);
    b.writeInt(this.state);
  }
  
  public void release() {
    //do nothing
  }
}