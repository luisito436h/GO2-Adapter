package net.skimnerphi.go2.network;

import com.igg.go2.common.MsgHead;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class Response extends Thread {
  private final Connection inst;
  public boolean running;
  
  private final CopyOnWriteArrayList<MessageListener> listeners;
  
  public Response(Connection instance) {
    this.inst = instance;
    
    this.listeners = new CopyOnWriteArrayList<>();
  }
  
  public void addMessageListener(MessageListener ml) {
    this.listeners.addIfAbsent(ml);
  }
  public void removeMessageListener(MessageListener ml) {
    this.listeners.remove(ml);
  }
  
  @Override
  public void run() {
    running = true;
    while(running) {
      try {
        MsgHead msg = this.inst.readMsg();

        for(MessageListener ml : this.listeners) {
          ml.messageRecieved(this.inst, msg);
        }
      } catch(IOException ex) {
        System.err.println(ex);
        running = false;
      }
      if(Thread.interrupted()) {
        this.inst.abortConnection();
        running = false;
      }
    }
  }
}
