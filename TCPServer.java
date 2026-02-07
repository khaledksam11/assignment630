import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000; 

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // رسالة تدل على أن الخادم بدأ العمل وينتظر العميل
            System.out.println("Server is running and waiting for connection on port " + port + "...");
            
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client Connected successfully!");

                // استقبال الرسالة من العميل
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = input.readLine();
                System.out.println("Received from client: " + message);

                // إرسال رد تأكيدي للعميل
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("Hello Client, your message was received by the Server.");
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
        // java TCPServer.java
    }
}
