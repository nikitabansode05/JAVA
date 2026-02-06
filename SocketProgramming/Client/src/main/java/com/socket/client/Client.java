package com.socket.client;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {

        try {

            // Step 1: Connect to Server
            Socket socket =
                new Socket("localhost", 5000);

            System.out.println("Connected to server");

            // Step 2: Input and Output Streams
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );

            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Send message
            out.println("Hello Server!");

            // Step 4: Read response
            String response = in.readLine();
            System.out.println("Server says: " + response);

            // Step 5: Close
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
