package com.corona;
 
import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    public Server(int port) {
        this.port = port;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Dinlenen port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");

                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();

            }

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

  //Kullanıcadan mesaj broadcast ediliyor
    
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {

                aUser.sendMessage(message);

        }
    }

  //yeni kullanıcı clint'e baglanınca haber veriliyor
    void addUserName(String userName) {
        userNames.add(userName);
    }

  //kullanıcı çıkınca çıktı diye haber veriliyor ama bizim burda buna ihtiyacımız yok
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}