package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class AgeFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> ageFilter;

    private List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @Before
    public void init(){
        initMocks(this);
        ageFilter = new AgeFilter();

    }

    @Test
    public void testAgeFilter(){
        profiles = ProfileUtility.getProfiles();
        criteria = new MatchSearchCriteria();
        criteria.setMinAge(40);
        criteria.setMaxAge(50);
        List<Profile> filteredProfiles = ageFilter.filter(profiles,criteria);
        assertEquals(3,filteredProfiles.size());
    }



}