package com.project.moviesApp.dao;

import com.project.moviesApp.exceptions.EmailAlreadyExistsException;
import com.project.moviesApp.exceptions.MovieAlreadyAddedException;
import com.project.moviesApp.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    void register(User user) throws SQLException, EmailAlreadyExistsException;
    User login(String email,  String password) throws SQLException;
    void addBookmark(User user, String movieID) throws SQLException, MovieAlreadyAddedException;
    List<String> getBookmarks(User user) throws SQLException;
    void addLike(User user, String movieID) throws SQLException, MovieAlreadyAddedException;
    List<String> getLikes(User user) throws SQLException;
}
