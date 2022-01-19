package com.bs.codetest.api.exception;


public class NonRecoverableException extends RuntimeException {


    public NonRecoverableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonRecoverableException(String message) {
        this(message, null);
    }

}
