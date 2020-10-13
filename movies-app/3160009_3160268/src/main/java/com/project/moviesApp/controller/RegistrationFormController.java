package com.project.moviesApp.controller;


import com.project.moviesApp.controller.help.UserTransporter;
import com.project.moviesApp.exceptions.EmailAlreadyExistsException;
import com.project.moviesApp.model.User;
import com.project.moviesApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
public class RegistrationFormController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        ModelAndView mav = new ModelAndView("register.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("email " + email + " pass " + password + " registering.");
        User user = new User(email, password);
        if (!(email == null) && !(password == null)) {
            try {
                userService.registerUser(user);
                UserTransporter.setUser(user);
            } catch (EmailAlreadyExistsException e) {
                response.setStatus(400);
                response.getWriter().write(e.getMessage());
            }
        }
        mav.addObject("user", user);
        return mav;
    }

}
