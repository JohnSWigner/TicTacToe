package org.wigner.client;

import org.wigner.BoardValues;
import org.wigner.connection.ConnectionProvider;

import java.io.IOException;

import static org.wigner.client.GameRenderer.initializeBoard;
import static org.wigner.client.GameRenderer.printBoard;

public class TicTacToeGameManager {
    static ClientGameHandler handler;
    static boolean isMyTurn;
    private static BoardValues[][] boardState;
    public static void main(String[] args) {
        try {
            handler = new ClientGameHandler(ConnectionProvider.connect("localhost", 12345));
            boardState = initializeBoard();
            printBoard(boardState);
            runGame();
//            handler = new ClientGameHandler(ConnectionProvider.connect("localhost", 12345));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private static void runGame() {
        while (true) {
            if (isMyTurn) {

            }
        }
    }
}
