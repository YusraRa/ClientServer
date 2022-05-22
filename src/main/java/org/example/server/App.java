package org.example.server;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    private static Server server;
    public static void main(String[] args) throws IOException {
        server = new Server(3000);
        System.out.println("connected to database.");
        server.listen();
        System.out.println("server is running and listening ...");

    }
}