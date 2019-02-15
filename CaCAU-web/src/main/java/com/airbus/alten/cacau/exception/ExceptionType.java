package com.airbus.alten.cacau.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionType {

    HTTP_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occurred");

    private HttpStatus status;
    private String message;

    ExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
