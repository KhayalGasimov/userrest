package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotfoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public RecordNotfoundException(String message) {
        super(message);
    }

    public RecordNotfoundException(String message, Throwable t) {
        super(message, t);
}
}
