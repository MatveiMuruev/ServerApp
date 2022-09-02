import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("New connection accepted");
            printWriter.println("Write your name:");
            final String name = bufferedReader.readLine();
            printWriter.println("Are your child?");
            final String response = bufferedReader.readLine();
            printWriter.println(invite(response, name));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String invite(String response, String name) {

        if (response.equals("yes")) {
            return String.format("Welcome to the kids area, %s! Let's play!", name);
        }
        return String.format("Welcome to the adult zone, %s! have a good rest, or a good working day!", name);
    }

}
