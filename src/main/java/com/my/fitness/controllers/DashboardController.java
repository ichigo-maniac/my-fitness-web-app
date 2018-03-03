package com.my.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Dashboard controller
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    /**
     * Dashboard view page
     * @return View page
     */
    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String dashboard() {
        return "dashboard/dashboard";
    }

}
