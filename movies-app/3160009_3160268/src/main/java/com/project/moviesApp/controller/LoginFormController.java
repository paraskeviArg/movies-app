package com.project.moviesApp.controller;

import com.project.moviesApp.controller.help.UserTransporter;
import com.project.moviesApp.exceptions.WrongUsernameOrPasswordException;
import com.project.moviesApp.model.User;
import com.project.moviesApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class LoginFormController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mav = new ModelAndView("login.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (!(email == null) && !(password == null)) {
            User user = null;
            try {
                user = userService.loginUser(email, password);
                UserTransporter.setUser(user);
            } catch (WrongUsernameOrPasswordException e) {
                response.setStatus(401);
                response.getWriter().write(e.getMessage());
            } catch (SQLException e) {
                response.setStatus(402);
                response.getWriter().write(e.getMessage());
            }
            mav.addObject("user", user);
        }
        return mav;
    }
}
