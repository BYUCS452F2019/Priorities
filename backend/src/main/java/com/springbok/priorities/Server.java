package com.springbok.priorities;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static final int MAX_WAITING_CONNECTIONS = 12;

    private void run(String portNumber){
        System.out.println("Initializing Http server");
        HttpServer httpServer;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNumber)), MAX_WAITING_CONNECTIONS);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        httpServer.setExecutor(null);

        System.out.println("Creating contexts");
        httpServer.createContext("/", new ExecHandler ());
        System.out.println("Starting server");
        httpServer.start();
        System.out.println("Server started on port " + portNumber);
    }

    public static void main(String[] args){
        String portNumber = "8081";
        if (args.length > 0) {
            portNumber = args[0];
        }
        new Server().run(portNumber);
    }

}