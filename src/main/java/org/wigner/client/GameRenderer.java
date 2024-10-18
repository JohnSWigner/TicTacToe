package org.wigner.client;

import org.wigner.BoardValues;

/**
 * empty board:
 *    |   |
 *_____________
 *    |   |
 *_____________
 *    |   |
 *
 * full board:
 *  X | X | O
 *_____________
 *  O | O | X
 *_____________
 *  X | O | X
 *
 * coordinates:
 * 0,0|1,0|2,0
 *_____________
 * 0,1|1,1|2,1
 *_____________
 * 0,2|1,2|2,2
 */
public class GameRenderer {
    public static BoardValues[][] initializeBoard() {
        BoardValues[][] boardState = new BoardValues[][]{new BoardValues[3], new BoardValues[3], new BoardValues[3]};
        BoardValues[] row;
        for (int i=0;i<3;i++) {
            row = boardState[i];
            for (int j=0;j<3;j++) {
                row[j] = BoardValues.EMPTY;
            }
        }
        return boardState;
    }

    public static String printBoard(BoardValues[][] boardState) {
        String output = "";
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                output += " " + boardState[i][j].key + " ";
                if (j < 2) {
                    output += "|";
                } else {
                    output += "\n";
                }
            }
            if (i < 2) {
                output += "___________\n";
            }
        }
        System.out.println(output);
        return output;
    }
}
