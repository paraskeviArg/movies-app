package com.project.moviesApp.controller;

import com.project.moviesApp.controller.help.UserTransporter;
import com.project.moviesApp.exceptions.ListIsEmptyException;
import com.project.moviesApp.exceptions.MovieAlreadyAddedException;
import com.project.moviesApp.model.User;
import com.project.moviesApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "bookmark", method = RequestMethod.POST)
    public @ResponseBody void bookmarkMovie(@RequestBody String movieID,HttpServletResponse response) throws SQLException, IOException {
        User user = UserTransporter.getUser();
        try {
            userService.addUserBookmark(user, movieID);
        } catch (MovieAlreadyAddedException e) {
            response.setStatus(403);
            response.getWriter().write(e.getMessage());
        }

    }

    @RequestMapping(value = "my_bookmarks", method = RequestMethod.GET)
    public ModelAndView bookmarks() throws SQLException, ListIsEmptyException, IOException {
        User user = UserTransporter.getUser();
        List<String> bookmarks = new ArrayList<String>();
        try {
            bookmarks = userService.getUserBookmarks(user);
        } catch(ListIsEmptyException e) {
            bookmarks.add("\"empty\"");
        }
        System.out.println(bookmarks);
        return new ModelAndView("my_bookmarks.jsp", "bookmarks", bookmarks);
    }

    @RequestMapping(value = "like", method = RequestMethod.POST)
    public @ResponseBody void likeMovie(@RequestBody String movieID,HttpServletResponse response) throws SQLException, IOException {
        User user = UserTransporter.getUser();
        try {
            userService.addUserLike(user, movieID);
        } catch (MovieAlreadyAddedException e) {
            response.setStatus(403);
            response.getWriter().write(e.getMessage());
        }

    }

    @RequestMapping(value = "my_likes", method = RequestMethod.GET)
    public ModelAndView likes() throws SQLException{
        User user = UserTransporter.getUser();
        List<String> likes = new ArrayList<>();
        try {
            likes = userService.getUserLikes(user);
        } catch(ListIsEmptyException e) {
            likes.add("\"empty\"");
        }
        System.out.println(likes);
        return new ModelAndView("likes.jsp", "likes", likes);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public RedirectView logout() {
        System.out.println("logging out");
        UserTransporter.setUser(null);
        UserTransporter.logOut();
        return new RedirectView("/");
    }

}
