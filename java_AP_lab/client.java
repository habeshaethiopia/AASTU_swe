import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class client {

    DataOutputStream out;
    Socket socket;
    InputStreamReader c=new InputStreamReader(System.in);  
    BufferedReader cin=new BufferedReader(c); 

    client() {
        try {
            Socket socket = new Socket("127.0.0.1", 6060);
            System.out.println("hiiiiiii");
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
        String add = "";
        while (!add.equals("eol")) {
            try {
                System.out.println("enter sth");
                add = cin.readLine();
                out.writeUTF(add);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            cin.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        client C = new client();
    }
}
