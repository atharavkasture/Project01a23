import java.io.*;
import java.net.*;
public class FileServer {
    static final int PORT = 8080;
    static final int buffer = 1024;
    public static void main(String[] args)throws IOException {
        
        ServerSocket socket = new ServerSocket(PORT);
        System.out.println("Server running on PORT:"+PORT);
        System.out.println("Server waiting for connection");
        Socket server = socket.accept();
        byte[] buf = new byte[buffer];
        InputStream in = new BufferedInputStream(server.getInputStream());
        
        FileOutputStream fos = new FileOutputStream("received.txt");
        int read = 0;
        while((read = in.read(buf))!=-1){
            fos.write(buf,0,read);
        }
        fos.close();
        
        BufferedReader reader = new BufferedReader((new FileReader("received.txt")));
        String line="";
        while((line = reader.readLine())!=null){
            System.out.print(line);
        }
        reader.close();
        server.close();
        socket.close();
        
    }
}