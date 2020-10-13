package com.project.moviesApp.controller.help;

import com.project.moviesApp.model.User;

public class UserTransporter {

    private static User user;
    private static boolean loggedIn = false;


    public static void setUser(User user) {
        UserTransporter.user = user;
        UserTransporter.loggedIn = true;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static User getUser() {
        return user;
    }

    public static void logOut() {
        loggedIn = false;
    }
}