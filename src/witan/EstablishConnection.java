package witan;

import java.io.*;
import java.net.Socket;

public class EstablishConnection {
    EstablishConnection(String username, String serverName, String port) {
        int portAsInt = Integer.parseInt(port);
        try {
            System.out.println("Connecting to " + serverName + " on port " + portAsInt);
            Socket client = new Socket(serverName, portAsInt);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress() + "said " + username);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
