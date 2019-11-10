package com.asal.customException;

public class CarInUseException extends Exception {

    private String details;
    private String nextActions;

    public CarInUseException(String message, String details, String nextActions) {
        super(message);
        this.details = details;
        this.nextActions = nextActions;
    }
}
