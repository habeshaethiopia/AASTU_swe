import java.net.*;
import java.util.Scanner;

public class javainlet {
    public static void main(String[] args) {
        try {
            // byte add[]={142,250,201,142};
            Scanner cin = new Scanner(System.in);
            System.out.println("Enter website Full url:");
            String website = cin.nextLine();
            cin.close();
            InetAddress ip = InetAddress.getByName(website);
            System.out.println("HOST ip address :"+ip.getHostAddress());
            System.out.println("HOST Name :"+ip.getHostName());

        } catch (UnknownHostException e) {

            System.out.println("\nwebsite not found\n");
        }

    }

}
