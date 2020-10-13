package com.project.moviesApp.dao;

import com.project.moviesApp.exceptions.EmailAlreadyExistsException;
import com.project.moviesApp.exceptions.MovieAlreadyAddedException;
import com.project.moviesApp.model.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.project.moviesApp.dao.dbutil.DBUtil.closeConnection;
import static com.project.moviesApp.dao.dbutil.DBUtil.openConnection;

@Service
public class UserDAOImpl implements IUserDAO {


    @Override
    public void register(User user) throws SQLException, EmailAlreadyExistsException {

        String sql = "INSERT INTO USERS VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "')";
        PreparedStatement pst = openConnection().prepareStatement(sql);
        try {
            pst.executeUpdate(sql);
            System.out.println("user registered");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Email " + user.getEmail() + " is already being used.");
            throw new EmailAlreadyExistsException();
        }

        pst.close();
        closeConnection();
    }

    @Override
    public User login(String email, String password) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        PreparedStatement pst = openConnection().prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User(email, password);
            System.out.println("logged in");
        }
        return user;
    }

    @Override
    public void addBookmark(User user, String movieID) throws SQLException, MovieAlreadyAddedException {
        String sql = "SELECT COUNT(*) FROM BOOKMARKS WHERE movie_id = ? AND USERS_username= ? GROUP BY ? HAVING COUNT(*)>0";
        Connection conn = openConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, movieID);
        pst.setString(2, user.getEmail());
        pst.setString(3, movieID);
        ResultSet rs = pst.executeQuery();

        if(!rs.next()) {
            sql = "INSERT INTO BOOKMARKS VALUES ('" + movieID + "', '" + user.getEmail() + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
            System.out.println("bookmark added");
        } else {
            throw new MovieAlreadyAddedException();
        }
        pst.close();
        closeConnection();

    }

    @Override
    public List<String> getBookmarks(User user) throws SQLException {
        String sql = "SELECT MOVIE_ID FROM BOOKMARKS WHERE USERS_username = ?";
        PreparedStatement pst = openConnection().prepareStatement(sql);
        pst.setString(1, user.getEmail());
        ResultSet rs = pst.executeQuery();
        List<String> bookmarks = new ArrayList<>();
        while (rs.next()) {
            bookmarks.add(rs.getString("MOVIE_ID"));
        }
        return bookmarks;
    }

    @Override
    public void addLike(User user, String movieID) throws SQLException, MovieAlreadyAddedException {
        String sql = "SELECT COUNT(*) FROM LIKES WHERE movie_id = ? AND USERS_username= ? GROUP BY ? HAVING COUNT(*)>0";
        Connection conn = openConnection();

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, movieID);
        pst.setString(2, user.getEmail());
        pst.setString(3, movieID);
        ResultSet rs = pst.executeQuery();
        if(!rs.next()) {
            sql = "INSERT INTO LIKES VALUES ('" + movieID + "', '" + user.getEmail() + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
            System.out.println("like added");
        } else {
            throw new MovieAlreadyAddedException();
        }
        pst.close();
        closeConnection();

    }

    @Override
    public List<String> getLikes(User user) throws SQLException {
        String sql = "SELECT MOVIE_ID FROM LIKES WHERE USERS_username = ?";

        PreparedStatement pst = openConnection().prepareStatement(sql);
        pst.setString(1, user.getEmail());
        ResultSet rs = pst.executeQuery();
        List<String> likes = new ArrayList<>();
        while (rs.next()) {
            likes.add(rs.getString("MOVIE_ID"));
        }
        return likes;
    }

}


