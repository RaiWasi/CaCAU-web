package com.airbus.alten.cacau.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;

public class ApplicationSpecificException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final ExceptionType exceptionType;

    public ApplicationSpecificException(ExceptionType exceptionType, Object... messageArguments) {
        super(MessageFormat.format(exceptionType.getMessage(), messageArguments));
        this.exceptionType = exceptionType;
    }

    public ApplicationSpecificException(ExceptionType exceptionType, final Throwable cause, Object... messageArguments) {
        super(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        this.exceptionType = exceptionType;
    }

    public HttpStatus getHttpStatus() {
        return exceptionType.getStatus();
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}
