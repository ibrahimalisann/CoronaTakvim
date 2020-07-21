package com.corona;

import java.net.*;
import java.io.*;


public class Client {
    private String hostname;
    private int port;
    private String userName;
    private static WriteThread writeThread;
    private static Client client;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute(ClientGui gui) {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Server'a baglanildi");

            new ReadThread(socket, this, gui).start();
            writeThread = new WriteThread(socket, this);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

    public static Client getInstance() {
        if(client != null) {
            return client;
        } else {
            return new Client("127.0.0.1", 3333);
        }
    }
}