package com.bs.codetest.api.exception;


public class RecoverableException extends RuntimeException {

    public RecoverableException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecoverableException(String message) {
        this(message, null);
    }


}
