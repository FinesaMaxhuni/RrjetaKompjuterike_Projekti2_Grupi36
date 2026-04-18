import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static List<ClientHandler> clients = new ArrayList<>();
    public static List<String> messages = new ArrayList<>();
    public static List<String> clientIPs = new ArrayList<>();

    public static final int PORT = 1234;
    public static final int MAX_CLIENTS = 5;
