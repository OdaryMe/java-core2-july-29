package ru.geekbrains.java_core2.lessons.l6_net;

import java.io.*;
import java.net.Socket;

public class Handler implements Closeable {
    private MyServer server;
    private Thread oneClientThread;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private int number;

    public Handler(Socket socket, MyServer server, int number) {
        try {
            this.server = server;
            this.number = number;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void handle() {
        oneClientThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        var message = getMessage();
                        System.out.format("received from # %d: %s\n", number, message);
                        server.broadcastMessage(message, number);
                    } catch (IOException e) {
                          System.out.format("Connection with # %d is interrupted\n", number);
                        try {
                            close();
                        } catch (IOException ex) {
                            e.printStackTrace();
                        }
                        server.removeHandler(number);
                        break;
                    }
                }
        });
        oneClientThread.start();
    }

    public void sendMessage(String message, int number) {
        try {
            String response = String.format("From # %d: %s", number, message);
            out.writeUTF(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() throws IOException {
        var message = in.readUTF();
        if(message.startsWith("/end")) {
            close();
            server.removeHandler(number);
        }
        return message;
    }

    @Override
    public void close() throws IOException {
            if(oneClientThread.isAlive()) {
                oneClientThread.interrupt();
            }
            if(socket != null) {
                socket.close();
            }
            in.close();
            out.close();
        System.out.format("Client # %d leaved\n", number);
    }
}



