package com.project.moviesApp.exceptions;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}
