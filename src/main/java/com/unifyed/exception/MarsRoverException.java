package com.unifyed.exception;

public class MarsRoverException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MarsRoverException(String exception) {
        super(exception);
    }
}
