package com.example.demo.exception;

/**
 * @author cuiyaocy
 */
public class ApiException extends Exception implements IServiceException {
    private ExceptionType exceptionType;

    @Override
    public ExceptionType getException() {
        return exceptionType;
    }

    public ApiException(String message, ExceptionType exceptionType) {
        super(composeMessage(exceptionType, message));
        this.exceptionType = exceptionType;
    }

    static String composeMessage(ExceptionType exceptionType, String message) {
        return "Message[" + exceptionType.name() + "]: " + message;
    }
}
