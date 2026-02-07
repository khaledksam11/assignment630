import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            // إرسال رسالة إنجليزية للخادم
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello Server, this is a test message from the Client!");

            // استقبال رد الخادم
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = input.readLine();
            System.out.println("Response from Server: " + response);

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
        // java TCPClient.java
    }
}
