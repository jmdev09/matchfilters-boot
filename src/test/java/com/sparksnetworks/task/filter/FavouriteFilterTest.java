package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.MatchConstants;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class FavouriteFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> favouriteFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        favouriteFilter = new FavouriteFilter();
    }

    @Test
    public void testFavouriteFilterWithYes(){
        criteria = new MatchSearchCriteria();
        criteria.setFavourite(MatchConstants.YES);
        List<Profile> filteredProfiles = favouriteFilter.filter(profiles,criteria);
        assertEquals(1,filteredProfiles.size());
    }

    @Test
    public void testFavouriteFilterWithNo(){
        criteria = new MatchSearchCriteria();
        criteria.setFavourite(MatchConstants.NO);
        List<Profile> filteredProfiles = favouriteFilter.filter(profiles,criteria);
        assertEquals(4,filteredProfiles.size());
    }

    @Test
    public void testFavouriteFilterWithAll(){
        criteria = new MatchSearchCriteria();
        criteria.setFavourite(MatchConstants.ALL);
        List<Profile> filteredProfiles = favouriteFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }

}