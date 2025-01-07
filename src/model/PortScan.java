package model;

import java.net.Socket;

public class PortScan {

  public static boolean isPortOpen(InternetProtocolAddress host, int port) {
    try (Socket socket = new Socket()) {
      socket.connect(new java.net.InetSocketAddress(host.toString(), port), 2000);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
