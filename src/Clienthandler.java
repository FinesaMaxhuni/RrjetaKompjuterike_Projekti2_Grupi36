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

    public void run() {
        String command;

        try {
            while ((command = in.readLine()) != null) {

                Server.messages.add(command);

                if (!isAdmin) {
                    Thread.sleep(1000);
                }

                if (command.equals(&quot;/list&quot;)) {
                    listFiles();

                } else if (command.startsWith(&quot;/read&quot;)) {
                    readFile(command);

                } else if (command.startsWith(&quot;/delete&quot;)) {
                    deleteFile(command);

                } else if (command.startsWith(&quot;/upload&quot;)) {
                    uploadFile(command);

                } else if (command.startsWith(&quot;/download&quot;)) {
                    downloadFile(command);

                } else if (command.startsWith(&quot;/search&quot;)) {

                    searchFiles(command);

                } else if (command.startsWith(&quot;/info&quot;)) {
                    fileInfo(command);

                } else {
                    out.println(&quot;Unknown command&quot;);
                }
            }

        } catch (SocketTimeoutException e) {
            System.out.println(&quot;Client timeout: &quot; + socket.getInetAddress());

        } catch (Exception e) {
            System.out.println(&quot;Client disconnected&quot;);

        } finally {
            Server.clients.remove(this);
            try { socket.close(); } catch (Exception ignored) {}
        }
    }
