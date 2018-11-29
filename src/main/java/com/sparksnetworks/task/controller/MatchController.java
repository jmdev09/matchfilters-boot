package com.sparksnetworks.task.controller;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.model.Response;
import com.sparksnetworks.task.model.User;
import com.sparksnetworks.task.service.MatchService;
import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.model.Response;
import com.sparksnetworks.task.model.User;
import com.sparksnetworks.task.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@RestController
public class MatchController {

    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    private MatchService matchService;

    @RequestMapping("/displayString")
    public String displayString(){
        return matchService.displayInString();
    }

    @RequestMapping("/display")
    public Response display() throws Exception{
        return matchService.display();
    }

    @RequestMapping("/home")
    public List<Profile> home(@ModelAttribute(value="criteria") MatcherSearchCriteria criteria){
        logger.info("Got the Request");
        return matchService.getResponse(criteria);
    }

    @RequestMapping("/users")
    public List<User> getUsers(){
        return matchService.getUsers();
    }
}
