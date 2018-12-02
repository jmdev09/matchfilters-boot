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
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Maroju, Jithender on 29/11/18
 */
public class PhotoFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> photoFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        photoFilter = new PhotoFilter();
    }

    @Test
    public void testContactFilterForYes(){

        criteria = new MatchSearchCriteria();
        criteria.setPhoto(MatchConstants.YES);
        List<Profile> filteredProfiles = photoFilter.filter(profiles,criteria);
        assertEquals(5,filteredProfiles.size());
    }

    @Test
    public void testContactFilterForNo(){
        criteria = new MatchSearchCriteria();
        criteria.setPhoto(MatchConstants.NO);
        List<Profile> filteredProfiles = photoFilter.filter(profiles,criteria);
        assertEquals(0,filteredProfiles.size());
    }

    @Test
    public void testContactFilterForAll(){
        criteria = new MatchSearchCriteria();
        criteria.setPhoto(MatchConstants.ALL);
        List<Profile> filteredProfiles = photoFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }


}