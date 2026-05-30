import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            Socket socket = new Socket("localhost", 5000);

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Message: ");
                String msg = sc.nextLine();
                out.println(msg);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}