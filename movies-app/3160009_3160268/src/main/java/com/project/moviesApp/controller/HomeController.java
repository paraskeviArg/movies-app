package com.project.moviesApp.controller;

import com.project.moviesApp.controller.help.UserTransporter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav;
        mav = new ModelAndView("mainPage.jsp");

        return mav;
    }

    @RequestMapping(value = "redirectHome", method = RequestMethod.GET)
    public RedirectView redirectHome() {
        if(UserTransporter.isLoggedIn()) {
            return new RedirectView("logged_in");
        } else {
            return new RedirectView("/");
        }
    }

    @RequestMapping(value = "loginCheck", method = RequestMethod.GET)
    public boolean loginCheck() {
        System.out.println("logged in " + UserTransporter.isLoggedIn());
        if(UserTransporter.isLoggedIn()) {
            return true;
        } else {
            return false;
        }
    }
}
