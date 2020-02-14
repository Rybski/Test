package witan;

import java.io.*;
import java.net.*;

public class KnockKnockServer {
    KnockKnockServer(int portNumber) {

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
