package net.skimnerphi.go2.network;

import com.igg.go2.common.MsgHead;

/**
 * The listener interface for receiving messages. All associated methods will be invoked in the read thread of a connection.
 * @author SkimnerPhi
 */
public interface MessageListener {
  /**
   * Invoked when a message is received from the game server.
   * @param inst The receiving account instance
   * @param msg Message received
   */
  public abstract void messageReceived(Connection inst, MsgHead msg);
}
