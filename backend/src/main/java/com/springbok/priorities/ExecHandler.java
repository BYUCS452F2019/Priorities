package com.springbok.priorities;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.net.HttpURLConnection.HTTP_OK;

import com.google.gson.Gson;
import com.springbok.priorities.command.CommandManager;
import com.springbok.priorities.command.CommandResult;

public class ExecHandler implements HttpHandler {

    protected ExecHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
	    System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new Date()) + "] " + "Connection received: ");
        String requestJson = StreamProcessor.getString(exchange.getRequestBody());
        Gson gson = new Gson();
        boolean requestBody = !requestJson.isEmpty();

        try {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
            exchange.sendResponseHeaders(HTTP_OK, 0);
            if (requestBody) {
                RequestInfo requestInfo = gson.fromJson(requestJson, RequestInfo.class);
                CommandResult result = CommandManager.executeCommand(requestInfo);
                String response = gson.toJson(result);
                StreamProcessor.writeString(response, exchange.getResponseBody());
            }
            exchange.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }
    }

}