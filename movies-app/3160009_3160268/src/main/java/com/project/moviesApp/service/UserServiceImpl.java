package com.project.moviesApp.service;

import com.project.moviesApp.dao.IUserDAO;
import com.project.moviesApp.exceptions.EmailAlreadyExistsException;
import com.project.moviesApp.exceptions.ListIsEmptyException;
import com.project.moviesApp.exceptions.MovieAlreadyAddedException;
import com.project.moviesApp.exceptions.WrongUsernameOrPasswordException;
import com.project.moviesApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(User user) throws SQLException, EmailAlreadyExistsException {
        userDAO.register(user);
    }

    public User loginUser(String email, String password) throws SQLException, WrongUsernameOrPasswordException {
        User user = userDAO.login(email, password);
        if (user == null) {
            throw new WrongUsernameOrPasswordException();
        }
        return user;
    }

    @Override
    public void addUserBookmark(User user, String movieID) throws SQLException, MovieAlreadyAddedException {
        userDAO.addBookmark(user, movieID);

    }
    @Override
    public List<String> getUserBookmarks(User user) throws SQLException, ListIsEmptyException {
        List<String> bookmarks;
        bookmarks = userDAO.getBookmarks(user);

        if (bookmarks.isEmpty()) throw new ListIsEmptyException("Bookmarks");

        return bookmarks;
    }

    @Override
    public void addUserLike(User user, String movieID) throws SQLException, MovieAlreadyAddedException {
        userDAO.addLike(user, movieID);
    }

    @Override
    public List<String> getUserLikes(User user) throws SQLException, ListIsEmptyException {
        List<String> likes;
        likes = userDAO.getLikes(user);

        if (likes.isEmpty()) throw new ListIsEmptyException("Likes");

        return likes;
    }

}
