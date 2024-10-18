package org.wigner;

public enum BoardValues {
    EMPTY(" "),
    X("X"),
    O("O");
    public final String key;

    BoardValues(String key) {
        this.key = key;
    }
}
