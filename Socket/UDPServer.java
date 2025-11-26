import java.net.*;
import java.io.*;
public class UDPServer {
    public static void main(String[] args)throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);

        
        byte[] d1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(d1, d1.length);
        ds.receive(dp1);
        String x = new String(dp1.getData(),0,dp1.getLength()).trim();
        System.out.println("Message from client: "+x);

        String ans = "Hello Client";
        byte[] d2 = String.valueOf(ans).getBytes();
        InetAddress ia = dp1.getAddress();
        DatagramPacket dp2 = new DatagramPacket(d2, d2.length,ia,dp1.getPort());
        ds.send(dp2);

        

        ds.close();
    }
}
