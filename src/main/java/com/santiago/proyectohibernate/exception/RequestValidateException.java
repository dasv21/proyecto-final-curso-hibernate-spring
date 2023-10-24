package com.santiago.proyectohibernate.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestValidateException extends RuntimeException {

    private HttpStatus status;

    public RequestValidateException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
