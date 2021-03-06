package com.my.fitness.controllers;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Index page controller
 */
@Controller
public class IndexPageController {

    /**
     * User facade
     */
    @Autowired
    private UserFacade userFacade;

    /**
     * Index page
     * @return View template
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String indexPage() {
        if (!userFacade.isCurrentUserAnonymous()) {
            return FitnessWebAppConstants.REDIRECT.DASHBOARD;
        }
        return "index";
    }
}
