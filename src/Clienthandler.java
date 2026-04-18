import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean isAdmin = false;

    public ClientHandler(Socket socket) throws Exception {
        this.socket = socket;

        socket.setSoTimeout(30000);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        out.println(&quot;Enter username:&quot;);
        String user = in.readLine();

        if (user.equals(&quot;admin&quot;)) {
            isAdmin = true;
            out.println(&quot;You are admin&quot;);
        } else {
            out.println(&quot;You are normal user&quot;);
        }
    }