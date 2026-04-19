import com.google.gson.Gson;
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Executors;

public class httpstatsserver {

    public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.setExecutor(Executors.newFixedThreadPool(10));

        server.createContext("/stats", exchange -> {

            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            Map<String, Object> data = new HashMap<>();
            data.put("clients", Server.clients.size());
            data.put("ips", Server.clientIPs);
            data.put("messages_count", Server.messages.size());
            data.put("messages", Server.messages);

            Gson gson = new Gson();
            String response = gson.toJson(data);

            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");

            exchange.sendResponseHeaders(200, bytes.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }

        });

        server.start();
        System.out.println("HTTP stats server running on port 8080");
    }
}
