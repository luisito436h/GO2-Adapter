package net.skimnerphi.go2.network;

/**
 * Encapsulates connection information that is passed between the Login and Game servers
 * @author SkimnerPhi
 */
class GameAuth {
  final String ip;
  final int port;
  final String checkOutText;
  final String username;
  
  GameAuth(String ip, int port, String checkOutText, String username) {
    this.ip = ip;
    this.port = port;
    this.checkOutText = checkOutText;
    this.username = username;
  }
}