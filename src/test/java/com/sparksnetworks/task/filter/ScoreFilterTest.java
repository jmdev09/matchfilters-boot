package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class ScoreFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> scoreFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        scoreFilter = new ScoreFilter();
    }

    @Test
    public void testScoreFilter(){
        criteria = new MatchSearchCriteria();
        criteria.setMinScore(89.0);
        List<Profile> filteredProfiles = scoreFilter.filter(profiles,criteria);
        assertEquals(3,filteredProfiles.size());
    }

    @Test
    public void testScoreFilterWithMinScore(){
        criteria = new MatchSearchCriteria();
        criteria.setMinScore(87.0);
        List<Profile> filteredProfiles = scoreFilter.filter(profiles,criteria);
        assertEquals(4,filteredProfiles.size());
    }

    @Test
    public void testScoreFilterWithMaxScore(){
        criteria = new MatchSearchCriteria();
        criteria.setMaxScore(99.0);
        List<Profile> filteredProfiles = scoreFilter.filter(profiles,criteria);
        assertEquals(5,filteredProfiles.size());
    }
    @Test
    public void testScoreFilterWithNoCriteria(){
        criteria = new MatchSearchCriteria();
        List<Profile> filteredProfiles = scoreFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }

}