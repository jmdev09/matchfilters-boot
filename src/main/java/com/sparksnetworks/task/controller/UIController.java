package com.sparksnetworks.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Maroju, Jithender on 28/11/18
 */
@Controller
public class UIController {

    @RequestMapping("/")
    public String home(){
        return "filter";
    }
}
