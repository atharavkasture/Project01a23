import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Trig_UDP_Server {
    public static void main(String[] args)throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);

        
        byte[] d1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(d1, d1.length);
        ds.receive(dp1);
        String x = new String(dp1.getData(),0,dp1.getLength()).trim();
        int n = Integer.parseInt(x);

        byte[] d11 = new byte[1024];
        DatagramPacket dp11 = new DatagramPacket(d11, d11.length);
        ds.receive(dp11);
        String x1 = new String(dp11.getData(),0,dp11.getLength()).trim();
        double angle = Double.parseDouble(x1);
        angle = angle* Math.PI/180;

        double ans = 0;
        switch (n) {
            case 1:
                ans = Math.sin(angle);
                break;

            case 2:
                ans = Math.cos(angle);
            break;

            case 3:
                ans = Math.tan(angle);
            break;
        
            default:
                break;
        }
        

        byte[] d2 = String.valueOf(ans).getBytes();
        InetAddress ia = dp1.getAddress();
        DatagramPacket dp2 = new DatagramPacket(d2, d2.length,ia,dp1.getPort());
        ds.send(dp2);

        

        ds.close();
    }
}
