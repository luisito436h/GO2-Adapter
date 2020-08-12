package com.igg.go2.msg.commander;

import com.igg.go2.common.MsgTypes;
import net.skimnerphi.go2.util.ByteArray;

/**
 * <code>MSG_COMMANDERBASEINFO_TEMP</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class CommanderBaseInfo {
  public static final short LENGTH = 24 + MsgTypes.MAX_NAME;

  public String name;
  public long userId;
  public int commanderId;
  public int shipTeamId;
  public int state;
  public short skill;
  public byte level;
  public byte type;

  public CommanderBaseInfo() {
    super();
    this.skill = -1;
    this.userId = -1;
  }

  public void readBuf(ByteArray b) {
    this.name = b.readString(MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    this.userId = b.readLong();
    this.commanderId = b.readInt();
    this.shipTeamId = b.readInt();
    this.state = b.readInt();
    this.skill = b.readShort();
    this.level = b.readByte();
    this.type = b.readByte();
  }

  public void writeBuf(ByteArray b) {
    b.writeString(this.name, MsgTypes.MAX_NAME, ByteArray.CHARSET_UTF8);
    b.writeLong(this.userId);
    b.writeInt(this.commanderId);
    b.writeInt(this.shipTeamId);
    b.writeInt(this.state);
    b.writeShort(this.skill);
    b.writeByte(this.level);
    b.writeByte(this.type);
  }
}
