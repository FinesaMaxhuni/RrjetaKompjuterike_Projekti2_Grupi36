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

        out.println("Enter username:");
        String user = in.readLine();

        if (user.equals("admin")) {
            isAdmin = true;
            out.println("You are admin");
        } else {
            out.println("You are normal user");
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

                if (command.equals("/list")) {
                    listFiles();

                } else if (command.startsWith("/read")) {
                    readFile(command);

                } else if (command.startsWith("/delete")) {
                    deleteFile(command);

                } else if (command.startsWith("/upload")) {
                    uploadFile(command);

                } else if (command.startsWith("/download")) {
                    downloadFile(command);

                } else if (command.startsWith("/search")) {

                    searchFiles(command);

                } else if (command.startsWith("/info")) {
                    fileInfo(command);

                } else {
                    out.println("Unknown command");
                }
            }

        } catch (SocketTimeoutException e) {
            System.out.println("Client timeout: " + socket.getInetAddress());

        } catch (Exception e) {
            System.out.println(&quot;Client disconnected&quot;);

        } finally {
            Server.clients.remove(this);
            try { socket.close(); } catch (Exception ignored) {}
        }
    }

    private void listFiles() {
        File folder = new File("server_files");


        String[] files = folder.list();
        if (files != null) {
            for (String file : files) {
                out.println(file);
            }
        }
    }

    private void readFile(String cmd) throws Exception {
        String filename = cmd.split(" ")[1];
        File file = new File("server_files/" + filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
        reader.close();
    }

    private void deleteFile(String cmd) {
        if (!isAdmin) {
            out.println("No permission!");
            return;
        }

        String filename = cmd.split(" ")[1];
        File file = new File("server_files/" + filename);

        if (file.delete()) {
            out.println("Deleted");
        } else {
            out.println("Error deleting");
        }
    }

    private void uploadFile(String cmd) throws Exception {
        if (!isAdmin) {
            out.println("No permission!");
            return;
        }

        String filename = cmd.split(" ")[1];
        FileWriter writer = new FileWriter("server_files/" + filename);

        out.println("Send file content, type END to finish:");

        String line;
        while (!(line = in.readLine()).equals("END")) {
            writer.write(line + "\n");
        }

        writer.close();
        out.println("Uploaded");
    }

    private void downloadFile(String cmd) throws Exception {
        String filename = cmd.split(" ")[1];
        File file = new File("server_files/" + filename);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            out.println(line);
        }

        reader.close();
    }

    private void searchFiles(String cmd) {
        String keyword = cmd.split(" ")[1];
        File folder = new File(&quot;server_files&quot;);

        String[] files = folder.list();
        if (files != null) {
            for (String file : files) {
                if (file.contains(keyword)) {
                    out.println(file);
                }
            }
        }
    }

    private void fileInfo(String cmd) {
        String filename = cmd.split(" ")[1];
        File file = new File("server_files/" + filename);

        out.println("Size: " + file.length());

        out.println("Last modified: " + new Date(file.lastModified()));
    }
}
