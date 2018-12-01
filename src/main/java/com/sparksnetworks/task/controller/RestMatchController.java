package com.sparksnetworks.task.controller;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.service.MatchServiceImpl;
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
public class RestMatchController {

    private static final Logger logger = LoggerFactory.getLogger(RestMatchController.class);

    @Autowired
    private MatchServiceImpl matchServiceImpl;

    @RequestMapping("/results")
    public List<Profile> home(@ModelAttribute(value="criteria") MatchSearchCriteria criteria){
        logger.info("Got the Request for the criteria : " + criteria);
        return matchServiceImpl.getProfiles(criteria);
    }

}
