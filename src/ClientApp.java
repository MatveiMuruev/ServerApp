import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;
        try (Socket socket = new Socket(host, port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            Scanner in = new Scanner(System.in);

            System.out.println(bufferedReader.readLine());
            String name = in.nextLine();
            printWriter.println(name);
            System.out.println(bufferedReader.readLine());
            String response = in.nextLine();
            printWriter.println(response);
            System.out.println(bufferedReader.readLine());
            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
