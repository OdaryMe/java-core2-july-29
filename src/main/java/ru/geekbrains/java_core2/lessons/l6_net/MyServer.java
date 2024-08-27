package ru.geekbrains.java_core2.lessons.l6_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MyServer {
    private static final int PORT = 8189;
    private Socket socket;
    private int counter;

    private Map<Integer, Handler> handlers;

    public MyServer() {
            this.handlers = new HashMap<>();
        }


    public static void main(String[] args) {
        new MyServer().start();
    }

    public void start() {
        try(var serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            waitForConnection(serverSocket);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeHandler(int counter) {
        handlers.remove(counter);
    }

    private int pullRecipientNumber(String message) {
        int recipientNumber = 0;
        StringTokenizer tokenizer = new StringTokenizer(message);
        String firstArg = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
        String secondArg = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
        try {
            recipientNumber = parseInt(secondArg);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return recipientNumber;
    }

    public void broadcastMessage(String message, int counter) {
        if (message.startsWith("to")) {
            int recipientNumber = pullRecipientNumber(message);
            var recipient = handlers.get(recipientNumber);
            if (recipient == null) {
                System.out.println("Recipient not found");
            } else {
                recipient.sendMessage(message, counter);
            }
        } else {
            handlers.forEach((v, handler) -> handler.sendMessage(message, counter));
        }
    }


    private void waitForConnection(ServerSocket serverSocket) throws IOException {
        counter = 0;
        System.out.println("Waiting for connection...");
        try {
            while (true) {
                counter++;
                socket = serverSocket.accept();
                Handler handler = new Handler(socket, this, counter);
                handlers.put(counter, handler);
                System.out.printf("Client %s connected\n", counter);
                handler.handle();
            }
        } catch (SocketException e) {
            String warning = String.format("Connection with # %d is interrupted", counter);
            System.out.println(warning);
        }
    }
}
