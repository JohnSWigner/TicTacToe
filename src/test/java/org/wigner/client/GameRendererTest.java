package org.wigner.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wigner.BoardValues;

import static org.junit.jupiter.api.Assertions.*;

class GameRendererTest {

    @Test
    void printBoard_empty_matchesExpected() {
        //Arrange
        String expected = "   |   |   \n___________\n   |   |   \n___________\n   |   |   \n";
        BoardValues[][] state = GameRenderer.initializeBoard();

        //Act
        String actual = GameRenderer.printBoard(state);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printBoard_someValues_matchesExpected() {
        //Arrange
        String expected = "   | X | O \n___________\n X | O |   \n___________\n O |   |   \n";
        BoardValues[][] state = GameRenderer.initializeBoard();

        //Act
        state[0][1] = BoardValues.X;
        state[1][0] = BoardValues.X;
        state[0][2] = BoardValues.O;
        state[1][1] = BoardValues.O;
        state[2][0] = BoardValues.O;
        String actual = GameRenderer.printBoard(state);

        //Assert
        Assertions.assertEquals(expected, actual);
    }
}