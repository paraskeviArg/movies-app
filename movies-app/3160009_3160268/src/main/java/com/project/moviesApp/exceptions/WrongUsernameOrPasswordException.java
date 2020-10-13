package com.project.moviesApp.exceptions;

public class WrongUsernameOrPasswordException extends Exception {

    public WrongUsernameOrPasswordException() {
        super("Wrong username or password");
    }

}
