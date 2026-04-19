import com.google.gson.Gson;

public class HttpStatsServer {

    public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

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
        });

    }
}
