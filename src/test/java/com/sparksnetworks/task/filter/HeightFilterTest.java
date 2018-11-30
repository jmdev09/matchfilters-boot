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
public class HeightFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> heightFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        heightFilter = new HeightFilter();
    }

    @Test
    public void testHeightFilter(){
        criteria = new MatchSearchCriteria();
        criteria.setMinHeight(150);
        List<Profile> filteredProfiles = heightFilter.filter(profiles,criteria);
        assertEquals(4,filteredProfiles.size());
        criteria.setMinHeight(170);
        filteredProfiles = heightFilter.filter(profiles,criteria);
        assertEquals(2,filteredProfiles.size());
    }

    @Test
    public void testHeightFilterWithMinHeight(){
        criteria = new MatchSearchCriteria();
        criteria.setMinHeight(150);
        List<Profile> filteredProfiles = heightFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }

    @Test
    public void testHeightFilterWithMaxHeight(){
        criteria = new MatchSearchCriteria();
        criteria.setMinHeight(150);
        List<Profile> filteredProfiles = heightFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }
    @Test
    public void testHeightFilterWithNull(){
        criteria = new MatchSearchCriteria();
        criteria.setMinHeight(null);
        List<Profile> filteredProfiles = heightFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }

}