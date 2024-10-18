package org.wigner.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.wigner.connection.Keywords;
import org.wigner.connection.RequestTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.wigner.connection.Keywords.REQUEST_TYPE;

public class ClientGameHandler {
    private PrintWriter socketWriter;
    private BufferedReader socketReader;
    private BufferedReader consoleReader;
    Gson gson = new Gson();

    ClientGameHandler(Socket socket) throws IOException {
        socketWriter = new PrintWriter(socket.getOutputStream(), true);
        socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getUserInput() throws IOException {
        //TODO update this to prompt user to input either coordinates, or a message they would like to send
        return consoleReader.readLine();
    }

    public JsonObject getServerResponse() throws IOException {
        return JsonParser.parseString(socketReader.readLine()).getAsJsonObject();
    }

    public void sendServerMessage(JsonObject message) {
        socketWriter.println(gson.toJson(message));
    }

    private void handleResponse(JsonObject response) {

    }

    public boolean isItMyTurn() throws IOException {
        JsonObject request = new JsonObject();
        request.addProperty(REQUEST_TYPE.key, RequestTypes.IS_YOUR_TURN.key);
        sendServerMessage(request);

        JsonObject response = getServerResponse();
        while (!response.has(Keywords.IS_YOUR_TURN.key)) {
            handleResponse(response);
            response = getServerResponse();
        }
        return response.get(Keywords.IS_YOUR_TURN.key).getAsBoolean();
    }
}
