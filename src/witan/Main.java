package witan;


import java.io.IOException;
import java.util.Scanner;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String mode = "CMD";        // Flag to determine in which mode program should run (CMD or Graphic) maybe i should make it some kind of object
        String terminateNotification = "Application will now terminate";

        if (mode == "Graphic") {     // Checking in which mode program should run. Default mode is CMD.

        } else {
            System.out.println("What you want to do today?");
            System.out.println("1. Connect to server");
            System.out.println("2. Create server");
            System.out.println("3. Exit");

            Scanner scan = new Scanner(System.in);
            int numb = scan.nextInt();                              // User input

            switch (numb) {
                case 1:
                    ConnectToServer();
                    break;
                case 2:
                    CreateServer();
                    ConnectToServer();
                    break;
                case 3:
                    System.out.println(terminateNotification);
                    break;
                default:
                    System.out.println("Nothing was chosen." + terminateNotification);
            }
        }
    }

    private static void ConnectToServer() {
        DataHandler username = new DataHandler("username");
        String chosenUsername = username.data;
        DataHandler ipaddress = new DataHandler("ipaddress");
        String chosenIpaddress = ipaddress.data;
        DataHandler port = new DataHandler("port");
        String chosenPort = port.data;
        EstablishConnection connection = new EstablishConnection(chosenUsername, chosenIpaddress, chosenPort);
    }

    private static void CreateServer() throws IOException {
        DataHandler serverPort = new DataHandler("serverPort");
        int chosenServerPort = Integer.parseInt(serverPort.data);

        /*CreateNewThread serverThread = new CreateNewThread();
        Thread thread = new Thread(serverThread, "Server Thread");
        thread.start();
        serverThread.doStop();
        //System.out.println(thread.getName());
        */

        KnockKnockServer server = new KnockKnockServer(chosenServerPort);
    }
}
