import java.util.*;
import java.io.*;
import java.net.*;
public class TCPServer {
    static final int PORT = 8080;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket socket = new ServerSocket(PORT);
        System.out.println("Server running on PORT:"+PORT);
        System.out.println("Server waiting for connection");
        Socket server = socket.accept();        
        PrintWriter writer = new PrintWriter(server.getOutputStream(),true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
        String receivedString = reader.readLine();
        System.out.println("Client says: "+receivedString);
        System.out.println(server.getRemoteSocketAddress());
        System.out.println("What you want to tell to client?");
        String sendString = sc.nextLine();
        // String sendString = "Hello from Server";
        writer.println(sendString);
        server.close();
        socket.close();
        sc.close();
    }
}
