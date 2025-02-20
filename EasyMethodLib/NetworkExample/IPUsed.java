package EasyMethodLib.NetworkExample;

import java.io.IOException;
import java.net.*;

public class IPUsed {
    public static void main(String[] args) throws IOException {
        int port = 10086;
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        System.out.println(addr);
        InetAddress addr2 = InetAddress.getByName("TUF-Gaming-F15");
        System.out.println(addr2);

        System.out.println("\n" + addr.getHostName());
        System.out.println(addr.getHostAddress());
        System.out.println("\n" + addr2.getHostName());
        System.out.println(addr2.getHostAddress());

        DatagramSocket socket = new DatagramSocket();
        byte[] msg = ("你好哇！").getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length, addr, port);
        socket.send(packet);
    }
}
