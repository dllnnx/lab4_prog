package org.example.exceptions;

public class IllegalPersonMovingException extends Exception{
    private final String message;

    public IllegalPersonMovingException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
