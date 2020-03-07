package com.example.lovecode.exception;

public class TestException extends RuntimeException {

    String msg = "we have some error~";
    String errorCode = "1001";

    public TestException() {

    }

    public TestException(String msg, String errorCode) {
        this.msg = msg;
        this.errorCode = errorCode;
    }
}
