import java.net.*;
import java.io.*;
public class UDPClient {
    public static void main(String[] args)throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String i = "Hello, UDP Server!";
        byte[] d1 = String.valueOf(i).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(d1, d1.length,ia,9999);
        ds.send(dp1);

        byte[] d2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(d2, d2.length);
        ds.receive(dp2);
        String ans = new String(dp2.getData(),0,dp2.getLength()).trim();
        System.out.println("Message from Server: " + ans);

        ds.close();
    }
}
