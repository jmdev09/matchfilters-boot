package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.DistanceCalculator;
import com.sparksnetworks.task.util.MatchConstants;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Maroju, Jithender on 30/11/18
 */
public class DistanceFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> distanceFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        distanceFilter = new DistanceFilter();
    }

    @Test
    public void testDistanceFilter(){
        criteria = new MatchSearchCriteria();
        criteria.setDistance(150);
        List<Profile> filteredProfiles = distanceFilter.filter(profiles,criteria);
        assertEquals(2,filteredProfiles.size());
        Profile loggedInUser = profiles.get(MatchConstants.LOGGEDIN_PROFILE_INDEX);
        assertDistance(loggedInUser,filteredProfiles, 150);

    }

    private void assertDistance(Profile loggedInProfile, List<Profile> filteredProfiles, double distance) {
        for (Profile profile : filteredProfiles){
            double calcultedDistance = DistanceCalculator.distance(loggedInProfile, profile);
            assertTrue(calcultedDistance <= distance);
        }
    }

}