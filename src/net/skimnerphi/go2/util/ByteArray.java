package net.skimnerphi.go2.util;

import java.io.UnsupportedEncodingException;

/**
 * The ByteArray class serves to replace <code>flash.utils.ByteArray</code> and significant portions of <code>net.base.MsgSocket</code> from the source.<br/>
 * All methods expect little endian format. The remaining space should be verified before performing <code>read()</code> methods to prevent IndexOutOfBoundsExceptions.
 * @author SkimnerPhi
 */
public class ByteArray {
  /**
   * Size of a <code>boolean</code> primitive in bytes
   */
  public static final int LEN_BOOLEAN = 1;
  /**
   * Size of a <code>byte</code> primitive in bytes
   */
  public static final int LEN_BYTE = 1;
  /**
   * Size of a <code>char</code> primitive in bytes
   */
  public static final int LEN_CHAR = 1;
  /**
   * Size of a <code>short</code> primitive in bytes
   */
  public static final int LEN_SHORT = 2;
  /**
   * Size of an <code>int</code> primitive in bytes
   */
  public static final int LEN_INT = 4;
  /**
   * Size of a <code>long</code> primitive in bytes
   */
  public static final int LEN_LONG = 8;
  /**
   * Multiplier for size of a <code>String</code> in bytes (times length)
   */
  public static final int LEN_STRING_MULTIPLIER = 1;
  /**
   * Multiplier for size of a UTF-8 encoded <code>String</code> in bytes (times length)
   */
  public static final int LEN_UTF8STRING_MULTIPLIER = 1;
  /**
   * Multiplier for size of a wide encoded <code>String</code> in bytes (times length)
   */
  public static final int LEN_WIDESTRING_MULTIPLIER = 2;
  
  private static final int STARTING_SIZE = 16;
  private static final int INCREMENT_SIZE = 16;
  
  private byte[] buffer;
  private int position;
  private int size;
  
  /**
   * Create an empty ByteArray
   */
  public ByteArray() {
    buffer = new byte[STARTING_SIZE];
    position = 0;
    size = 0;
  }
  /**
   * Create an empty ByteArray of at least a certain size
   * @param length The minimum amount to preallocate
   */
  public ByteArray(int length) {
    //The length of the buffer array isn't exactly length and is instead the next increment amount above the length
    int realLength = STARTING_SIZE;
    realLength += ((length - STARTING_SIZE) / INCREMENT_SIZE + 1) * INCREMENT_SIZE;
    buffer = new byte[realLength];
    position = 0;
    size = 0;
  }
  /**
   * Create a ByteArray with existing data
   * @param data The existing data
   */
  public ByteArray(byte[] data) {
    buffer = new byte[data.length + INCREMENT_SIZE - data.length % INCREMENT_SIZE];
    System.arraycopy(data, 0, buffer, 0, data.length);
    position = 0;
    size = data.length;
  }
  
  /**
   * Add a new value to the end of the ByteArray. Use <code>writeByte()</code> for public use.
   * @param b Value to add
   */
  private void push(byte b) {
    if(buffer.length == size) {
      byte[] oldBuffer = buffer;
      buffer = new byte[buffer.length + INCREMENT_SIZE];
      System.arraycopy(oldBuffer, 0, buffer, 0, size);
    }
    buffer[size] = b;
    size++;
  }
  
  public void writeBoolean(boolean b) {
    push(b?(byte)1:(byte)0);
  }
  public boolean readBoolean() {
    return buffer[position++]!=0;
  }
  
  public void writeByte(byte b) {
    push(b);
  }
  public byte readByte() {
    return buffer[position++];
  }
  
  public void writeChar(char c) {
    push((byte)c);
  }
  public char readChar() {
    return (char)buffer[position++];
  }
  
  public void writeShort(short s) {
    push((byte)(s & 0x00FF));
    push((byte)(s >> 8));
  }
  public short readShort() {
    short ret = 0;
    ret |= buffer[position++] & 0xFF;
    ret |= (buffer[position++] & 0xFF) << 8;
    return ret;
  }
  
  public void writeInt(int i) {
    push((byte)(i & 0x000000FF));
    push((byte)((i & 0x0000FF00) >> 8));
    push((byte)((i & 0x00FF0000) >> 16));
    push((byte)(i >> 24));
  }
  public int readInt() {
    int ret = 0;
    ret |= buffer[position++] & 0xFF;
    ret |= (buffer[position++] & 0xFF) << 8;
    ret |= (buffer[position++] & 0xFF) << 16;
    ret |= (buffer[position++] & 0xFF) << 24;
    return ret;
  }
  
  public void writeLong(long l) {
    push((byte)(l & 0x00000000000000FFl));
    push((byte)((l & 0x000000000000FF00l) >> 8));
    push((byte)((l & 0x0000000000FF0000l) >> 16));
    push((byte)((l & 0x00000000FF000000l) >> 24));
    push((byte)((l & 0x000000FF00000000l) >> 32));
    push((byte)((l & 0x0000FF0000000000l) >> 40));
    push((byte)((l & 0x00FF000000000000l) >> 48));
    push((byte)(l >> 56));
  }
  public long readLong() {
    long ret = 0;
    ret |= buffer[position++] & 0xFFl;
    ret |= (buffer[position++] & 0xFFl) << 8;
    ret |= (buffer[position++] & 0xFFl) << 16;
    ret |= (buffer[position++] & 0xFFl) << 24;
    ret |= (buffer[position++] & 0xFFl) << 32;
    ret |= (buffer[position++] & 0xFFl) << 40;
    ret |= (buffer[position++] & 0xFFl) << 48;
    ret |= (buffer[position++] & 0xFFl) << 56;
    return ret;
  }
  
  /**
   * Simple ASCII encoding, one byte per character.
   */
  public static final int CHARSET_ASCII = 0;
  /**
   * UTF-8 encoding, one byte per character.
   */
  public static final int CHARSET_UTF8 = 1;
  /**
   * UTF=16 encoding, two bytes per character,  little endian.
   */
  public static final int CHARSET_WIDE = 2;
  
  /**
   * Writes a String to the buffer padding to a certain length with the specified encoding. Defaults to ASCII if <code>charset</code> is unspecified or invalid.
   * @param s String to write
   * @param len Specified length in bytes. If the String is longer than this it will be truncated, if the String is shorter it will be padded with <code>NUL</code> characters.
   * @param charset Encoding pattern, referenced by a <code>CHARSET_*</code> flag.
   */
  public void writeString(String s, int len, int charset) {
    String cs = "US-ASCII";
    int lenMult = LEN_STRING_MULTIPLIER;
    switch(charset) {
      case CHARSET_UTF8:
        cs = "UTF-8";
        lenMult = LEN_UTF8STRING_MULTIPLIER;
        break;
      case CHARSET_WIDE:
        cs = "UTF-16LE";
        lenMult = LEN_WIDESTRING_MULTIPLIER;
        break;
    }
    len *= lenMult;
    
    try {
      byte[] str;
      if(s == null) {
        str = new byte[0];
      } else {
        str = s.getBytes(cs);
      }
      if(buffer.length - size < len) {
        byte[] oldBuffer = buffer;
        buffer = new byte[oldBuffer.length + INCREMENT_SIZE + len - len % INCREMENT_SIZE];
        System.arraycopy(oldBuffer, 0, buffer, 0, oldBuffer.length);
      }
      System.arraycopy(str, 0, buffer, size, Math.min(len, str.length));
      size += len;
    } catch(UnsupportedEncodingException e) {
      System.err.println(e);
      System.exit(-1);
    }
  }
  /**
   * Reads the next value as a String assuming padding to a certain length with the specified encoding. Defaults to ASCII if <code>charset</code> is unspecified or invalid.
   * @param len Specified length in bytes. If the String is longer than this it will be truncated, if the String is shorter it will be padded with <code>NUL</code> characters.
   * @param charset Encoding pattern, referenced by a <code>CHARSET_*</code> flag.
   * @return Read String
   */
  public String readString(int len, int charset) {
    String cs = "US-ASCII";
    int lenMult = LEN_STRING_MULTIPLIER;
    switch(charset) {
      case CHARSET_UTF8:
        cs = "UTF-8";
        lenMult = LEN_UTF8STRING_MULTIPLIER;
        break;
      case CHARSET_WIDE:
        cs = "UTF-16LE";
        lenMult = LEN_WIDESTRING_MULTIPLIER;
        break;
    }
    len *= lenMult;
    try {
      String ret = new String(buffer, position, len, cs);
      
      int end = ret.indexOf(0);
      if(end != -1) {
        ret = ret.substring(0, end);
      }
      
      position += len;
      return ret;
    } catch(UnsupportedEncodingException e) {
      System.err.println(e);
      System.exit(-1);
      return null;
    }
  }
  
  /**
   * Pads the end of the ByteArray with 0s. Does nothing if <code>size</code> is less than the current size.<br/>
   * This is the same as calling <code>ByteArray.pushByte(size - ByteArray.size())</code>
   * @param size New expected size
   */
  public void padSize(int size) {
    pushByte(size - this.size);
  }
  /**
   * Pads the end of the ByteArray with 0s
   * @param len Number of bytes to append
   */
  public void pushByte(int len) {
    if(len <= 0) {
      return;
    }
    if(buffer.length - size < len) {
      byte[] oldBuffer = buffer;
      buffer = new byte[oldBuffer.length + INCREMENT_SIZE + len - len % INCREMENT_SIZE];
      System.arraycopy(oldBuffer, 0, buffer, 0, oldBuffer.length);
    }
    size += len;
  }
  
  public int size() {
    return size;
  }
  public int getPosition() {
    return position;
  }
  public int sizeRemaining() {
    return size - position;
  }
  
  public void setPosition(int index) {
    position = index;
  }
  
  /**
   * The raw byte array
   * @return The entire byte array
   */
  public byte[] data() {
    byte[] data = new byte[size];
    System.arraycopy(buffer, 0, data, 0, size);
    return data;
  }
  
  /**
   * 
   */
  public String toHexSequence() {
    String ret = "";
    for(int idx = 0; idx < size; idx++) {
      String add = Integer.toHexString(buffer[idx] & 0xFF);
      ret += ((add.length() == 1)?"0":"") + add + ((idx % 16 == 15)?"\n":" ");
    }
    return ret;
  }
}
