import com.google.gson.Gson;

public class HttpStatsServer {

    public static void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

    }
}
