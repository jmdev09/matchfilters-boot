package com.sparksnetworks.task.service;

import com.sparksnetworks.task.dao.MatchDAOImpl;
import com.sparksnetworks.task.filter.MatchSearchFilters;
import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDAOImpl matchDAOImpl;

    @Autowired
    private MatchSearchFilters searchFilters;

    @Override
    public List<Profile> getProfiles(MatchSearchCriteria matchSearchCriteria){
        List<Profile> profiles =  matchDAOImpl.getAllProfiles();
        List<Profile> filteredProfiles = searchFilters.filter(profiles, matchSearchCriteria);
        return filteredProfiles;
    }
}
