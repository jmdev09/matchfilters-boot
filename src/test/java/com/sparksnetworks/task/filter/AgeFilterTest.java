package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class AgeFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> ageFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        ageFilter = new AgeFilter();
    }

    @Test
    public void testAgeFilter(){
        criteria = new MatchSearchCriteria();
        criteria.setMinAge(40);
        criteria.setMaxAge(50);
        List<Profile> filteredProfiles = ageFilter.filter(profiles,criteria);
        assertEquals(3,filteredProfiles.size());
    }


    @Test
    public void testAgeFilterWithMinHeight(){
        criteria = new MatchSearchCriteria();
        criteria.setMinAge(30);
        List<Profile> filteredProfiles = ageFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }

    @Test
    public void testAgeFilterWithMaxAge(){
        criteria = new MatchSearchCriteria();
        criteria.setMaxAge(40);
        List<Profile> filteredProfiles = ageFilter.filter(profiles,criteria);
        assertEquals(1,filteredProfiles.size());
    }
    @Test
    public void testAgeFilterWithNoCriteria(){
        criteria = new MatchSearchCriteria();
        List<Profile> filteredProfiles = ageFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }



}