package com.project.moviesApp.exceptions;

public class ListIsEmptyException extends Exception {

    public ListIsEmptyException(String type) {
        super("The " + type + " list is empty.");
    }
}
