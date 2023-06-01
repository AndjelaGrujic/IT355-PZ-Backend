package com.metropolitan.exception;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("User with this username alredy exist!!");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
