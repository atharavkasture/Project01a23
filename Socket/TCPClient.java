import java.util.*;
import java.io.*;
import java.net.*;

public class TCPClient {
    static final int PORT = 8080;
    static final String IP = "localhost";
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);        
        Socket client = new Socket(IP,PORT);
        System.out.println("Enter what to send to server?");
        String sendString = sc.nextLine();
        // String sendString = "Hello from Client";
        PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer.println(sendString);
        String receivedString = reader.readLine();
        System.out.println("Server says: "+receivedString);        
        client.close();
        sc.close();
    }
}
