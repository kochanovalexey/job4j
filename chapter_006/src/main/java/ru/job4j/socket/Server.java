package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 18.12.2019
 */
public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if ("How are you".equals(ask)) {
                out.println("All fine, thank you!");
                out.println();
            } else if (!"exit".equals(ask)) {
                out.println("Sorry, I don`t understand you.");
                out.println();
            }
            out.flush();
        } while (!"exit".equals(ask));
    }

    public static void main(String[] args) throws IOException{
        try(Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        }
    }
}
