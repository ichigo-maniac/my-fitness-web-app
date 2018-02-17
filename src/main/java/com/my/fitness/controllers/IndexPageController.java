package com.my.fitness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Index page controller
 */
@Controller
public class IndexPageController {

    /**
     * Index page
     * @return View template
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String indexPage() {
        return "index";
    }
}
