package com.project.moviesApp.exceptions;

public class MovieAlreadyAddedException extends Exception {

    public MovieAlreadyAddedException() {
        super("Movie has already been added to this list.");
    }
}
