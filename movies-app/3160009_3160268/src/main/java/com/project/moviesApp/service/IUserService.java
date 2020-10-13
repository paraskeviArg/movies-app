package com.project.moviesApp.service;

import com.project.moviesApp.exceptions.EmailAlreadyExistsException;
import com.project.moviesApp.exceptions.ListIsEmptyException;
import com.project.moviesApp.exceptions.MovieAlreadyAddedException;
import com.project.moviesApp.exceptions.WrongUsernameOrPasswordException;
import com.project.moviesApp.model.User;

import java.sql.SQLException;
import java.util.List;


public interface IUserService {

    void registerUser(User user) throws SQLException, EmailAlreadyExistsException;
    User loginUser(String email, String password) throws SQLException, WrongUsernameOrPasswordException;
    void addUserBookmark(User user, String movieID) throws SQLException, MovieAlreadyAddedException;
    List<String> getUserBookmarks(User user) throws SQLException, ListIsEmptyException;
    void addUserLike(User user, String movieID) throws SQLException, MovieAlreadyAddedException;
    List<String> getUserLikes(User user) throws SQLException, ListIsEmptyException;
}
