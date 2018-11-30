package com.sparksnetworks.task.service;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;

import java.util.List;

/**
 * @author Maroju, Jithender on 30/11/18
 */
public interface MatchService {

    List<Profile> getProfiles(MatchSearchCriteria matchSearchCriteria);
}
