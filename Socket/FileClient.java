import java.io.*;
import java.net.*;

public class FileClient {
    static final int PORT = 8080;
    static final String IP = "localhost";
    static final int buffer = 1024;
    public static void main(String[] args)throws IOException {
        
        Socket client = new Socket(IP,PORT);
        byte[] buf = new byte[buffer];
        File f = new File("input.txt");
        OutputStream out = new BufferedOutputStream(client.getOutputStream());
        FileInputStream fin = new FileInputStream(f);
        int read = 0;
        while((read = fin.read(buf))!=-1){
            out.write(buf,0,read);
            out.flush();
            System.out.write(buf,0,read);
        }
        client.shutdownOutput();
        fin.close();       
        out.close();
        
        client.close();
        
    }
}
