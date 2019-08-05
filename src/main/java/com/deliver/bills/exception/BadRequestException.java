package com.deliver.bills.exception;

public class BadRequestException extends Exception {

    public BadRequestException(String s) {
        super(s);
    }

    public BadRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }
}