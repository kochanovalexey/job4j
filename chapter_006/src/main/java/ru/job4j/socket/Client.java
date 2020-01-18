package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 19.12.2019
 */
public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String msg = null;
        do {
            out.println(msg = console.nextLine());
            String str;
            if (!"exit".equals(msg)) {
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            }
            out.flush();
        } while (!"exit".equals(msg));
    }

    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000)) {
            new Client(socket).start();
        }
    }
}
