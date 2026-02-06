package com.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {

            // Step 1: Create Server Socket (Port 5000)
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            // Step 2: Wait for client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            // Step 3: Input and Output Streams
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );

            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

            // Step 4: Communication
            String message = in.readLine();
            System.out.println("Client says: " + message);

            out.println("Hello Client, I received: " + message);

            // Step 5: Close
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
