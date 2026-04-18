import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static List<ClientHandler> clients = new ArrayList<>();
    public static List<String> messages = new ArrayList<>();
    public static List<String> clientIPs = new ArrayList<>();

    public static final int PORT = 1234;
    public static final int MAX_CLIENTS = 5;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        HttpStatsServer.start();

        while (true) {
            Socket socket = serverSocket.accept();

            if (clients.size() >= MAX_CLIENTS) {
                System.out.println("Too many clients. Connection refused.");
                socket.close();
                continue;
            }

