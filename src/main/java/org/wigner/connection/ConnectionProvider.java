package org.wigner.connection;

import java.io.IOException;
import java.net.Socket;

public class ConnectionProvider {
    public static Socket connect(String hostname, int port) throws IOException {
        Socket socket = new Socket(hostname, port);
        System.out.println(String.format("Connected to the server %s:%d", hostname, port));
        return socket;
    }
}
