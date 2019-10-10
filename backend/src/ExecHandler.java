package backend.src;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.net.HttpURLConnection.HTTP_OK;

import com.google.gson.Gson;

public class ExecHandler implements HttpHandler {

    protected ExecHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
	    System.out.print("[" + new SimpleDateFormat("HH.mm.ss").format(new Date()) + "] " + "Connection received: ");
        // String requestString = StreamProcessor.getString(exchange.getRequestBody());

        try {
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.sendResponseHeaders(HTTP_OK, 0);
            StreamProcessor.writeString("You should see this in the response of the network call", exchange.getResponseBody());
            exchange.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

}