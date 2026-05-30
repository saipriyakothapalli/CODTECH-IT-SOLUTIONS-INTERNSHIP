import java.io.*;
import java.net.*;

public class ChatServer {
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server Started...");

            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
            }

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}