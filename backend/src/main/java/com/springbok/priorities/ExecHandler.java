package com.springbok.priorities;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.springbok.priorities.authorization.Authorizer;
import com.springbok.priorities.command.CommandManager;
import com.springbok.priorities.command.CommandResult;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ExecHandler implements HttpHandler {

    protected ExecHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new Date()) + "] " + "Connection received: ");
        
            List<String> authCodes = exchange.getRequestHeaders().get("authcode");
            String authCode = "";
            if (authCodes != null && !authCodes.isEmpty()) {
                authCode = authCodes.get(0);
            }

            boolean authorized = false;

            String requestJson = StreamProcessor.getString(exchange.getRequestBody());
            Gson gson = new Gson();
            System.out.println(requestJson);
            boolean requestBody = !requestJson.isEmpty();

            // if (!authCode.isEmpty()) {
            //     authorized = Authorizer.checkAuthorization(authCode);
            // } 

            System.out.println(requestBody);
        
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
            if (requestBody) {
                RequestInfo requestInfo = gson.fromJson(requestJson, RequestInfo.class);
                String response = "";
                //if (requestInfo.type.equals("login") || requestInfo.type.equals("register") || authorized) 
                CommandResult result = CommandManager.executeCommand(requestInfo);
                response = gson.toJson(result);
                System.out.println(response);
                exchange.sendResponseHeaders(HTTP_OK, 0);
                StreamProcessor.writeString(response, exchange.getResponseBody());
            } else {
                exchange.sendResponseHeaders(HTTP_OK, 0);
            }
            exchange.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }
    }

}