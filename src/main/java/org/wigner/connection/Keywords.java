package org.wigner.connection;

public enum Keywords {
    IS_YOUR_TURN("isYourTurn"),
    X_COORD("xCoord"),
    Y_COORD("yCoord"),
    REQUEST_TYPE("requestType");
    public final String key;

    Keywords(String key) {
        this.key = key;
    }
}
