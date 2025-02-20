package EasyMethodLib.NetworkExample;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class User {
    static Scanner sc = new Scanner(System.in);
    public static volatile boolean control = false;

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Your IP Address is: " + InetAddress.getByName("TUF-Gaming-F15"));
        System.out.print("\nNow, enter your name : ");
        String name = sc.next();
        System.out.print("Enter want to send IP : ");
        String ip = sc.next();

        new Thread(new RunnableThread()).start();
        try {
            InetAddress addr = InetAddress.getByName(ip);
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                while (control) Thread.sleep(100);
                while (!control) {
                    System.out.print(">>> " + name + ": ");
                    String s = sc.next();
                    byte[] msg = ("> " + name + ": " + s).getBytes();
                    DatagramPacket dp = new DatagramPacket(msg, msg.length, addr, 10086);
                    socket.send(dp);
                    control = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class RunnableThread implements Runnable {
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(10086);
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024 * 1024], 1024 * 1024);
                socket.receive(packet);

                User.control = true;
                System.out.println(new String(packet.getData(), 0, packet.getLength()));
                User.control = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}