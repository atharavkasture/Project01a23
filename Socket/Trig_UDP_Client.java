import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Trig_UDP_Client {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();

        System.out.println("Enter your choice");
        int i = sc.nextInt();
        byte[] d1 = String.valueOf(i).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(d1, d1.length,ia,9999);
        ds.send(dp1);

        System.out.println("Enter your angle");
        double j = sc.nextDouble();
        byte[] d11 = String.valueOf(j).getBytes();
        InetAddress ia1 = InetAddress.getLocalHost();
        DatagramPacket dp11 = new DatagramPacket(d11, d11.length,ia1,9999);
        ds.send(dp11);

        byte[] d2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(d2, d2.length);
        ds.receive(dp2);
        String ans = new String(dp2.getData(),0,dp2.getLength()).trim();
        System.out.println("Answer is: " + ans);

        ds.close();
        sc.close();
    }
}
