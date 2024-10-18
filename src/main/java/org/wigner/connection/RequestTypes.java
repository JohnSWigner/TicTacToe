package org.wigner.connection;

public enum RequestTypes {
    IS_YOUR_TURN("isYourTurn"),
    MOVE("move"),
    MESSAGE("message");
    public final String key;

    RequestTypes(String key) {
        this.key = key;
    }
}
