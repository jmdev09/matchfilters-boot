package com.sparksnetworks.task.service;

import com.sparksnetworks.task.dao.MatchDAO;
import com.sparksnetworks.task.filter.MatchSearchFilters;
import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.model.Response;
import com.sparksnetworks.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Service
public class MatchService {

    @Autowired
    private MatchDAO matchDAO;

    @Autowired
    private MatchSearchFilters searchFilters;

    public Response display(){
        return matchDAO.getAllProfiles();
    }

    public List<Profile> getResponse(MatcherSearchCriteria matcherSearchCriteria){
        Response response =  matchDAO.getAllProfiles();
        validateSearchCriteria(matcherSearchCriteria);
        List<Profile> filteredProfiles = searchFilters.filter(response.getMatches(), matcherSearchCriteria);
        return filteredProfiles;
    }

    private void validateSearchCriteria(MatcherSearchCriteria matcherSearchCriteria) {

    }

    public List<User> getUsers(){
        return matchDAO.getUsers();
    }

    public String displayInString(){
        return matchDAO.getAllProfilesString();
    }
}
