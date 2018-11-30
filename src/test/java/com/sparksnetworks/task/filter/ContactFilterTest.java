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
public class ContactFilterTest {

    private MatchFilter<Profile,MatchSearchCriteria> contactFilter;

    private static List<Profile> profiles;

    private MatchSearchCriteria criteria;

    @BeforeClass
    public static void setup(){
        profiles = ProfileUtility.getProfiles();
    }

    @Before
    public void init(){
        initMocks(this);
        contactFilter = new ContactFilter();

    }

    @Test
    public void testContactFilterForYes(){

        criteria = new MatchSearchCriteria();
        criteria.setInContact(MatchConstants.YES);
        List<Profile> filteredProfiles = contactFilter.filter(profiles,criteria);
        assertEquals(2,filteredProfiles.size());
    }

    @Test
    public void testContactFilterForNo(){
        profiles = ProfileUtility.getProfiles();
        criteria = new MatchSearchCriteria();
        criteria.setInContact(MatchConstants.NO);
        List<Profile> filteredProfiles = contactFilter.filter(profiles,criteria);
        assertEquals(3,filteredProfiles.size());
    }

    @Test
    public void testContactFilterForAll(){
        profiles = ProfileUtility.getProfiles();
        criteria = new MatchSearchCriteria();
        criteria.setInContact(MatchConstants.ALL);
        List<Profile> filteredProfiles = contactFilter.filter(profiles,criteria);
        assertEquals(profiles.size(),filteredProfiles.size());
    }


}