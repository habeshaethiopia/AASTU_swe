import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    Socket socket;

    server(int port) {
        try {
            ServerSocket server = new ServerSocket(6060);
            System.out.println("server started");
            System.out.println("waiting for client");
            while (true) {
                try {
                    socket = server.accept();
                    System.out.println("Accepted connection from " + socket.getInetAddress() + ":" + socket.getPort());
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = "eof";
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Received message from " + socket.getInetAddress() + ":" + socket.getPort()
                                + ": " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Error accepting connection: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void main(String[] args) {
        server SER = new server(6060);
    }

}
