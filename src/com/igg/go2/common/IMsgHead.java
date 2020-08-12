package com.igg.go2.common;

/**
 * Appears to be an interface for packet headers.<br/>
 * <code>iMsgHead</code> in source.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public interface IMsgHead {
  /**
   * 
   * @param param1
   * @param param2
   * @param param3 Type currently unspecified, declared as <code>Array</code> in source
   */
  public abstract void pushField(String param1, String param2, Object[] param3);
  
  public abstract int getObjectLen(Object param1);
  /**
   * 
   * @param param1 Type currently unspecified, declared as <code>*</code> in source
   */
  public abstract void getVarType(Object param1);
  public abstract void setVarType(Object param1);
}
