package com.my.fitness.controllers;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;

/**
 * Logout controller
 */
@Controller
public class LogoutController {

    /**
     * User facade
     */
    @Autowired
    private UserFacade userFacade;

    /**
     * Log out
     * @return Redirect path
     * @throws ServletException Servlet exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() throws ServletException {
        userFacade.logOutCurrentUser();
        return FitnessWebAppConstants.REDIRECT.HOME;
    }
}
