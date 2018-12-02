package com.sparksnetworks.task.service;

import com.sparksnetworks.task.dao.MatchDAOImpl;
import com.sparksnetworks.task.filter.MatchSearchFilters;
import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.MatchConstants;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Maroju, Jithender on 02/12/18
 */
public class MatchServiceImplTest {

    @InjectMocks
    private MatchServiceImpl matchService;

    private MatchSearchCriteria criteria;

    @Mock
    private MatchDAOImpl matchDAO;

    @Mock
    private MatchSearchFilters matchSearchFilters;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        List<Profile> profiles = ProfileUtility.getProfiles();
        List<Profile> filteredProfiles = new ArrayList<>();
        filteredProfiles.add(profiles.get(3));
        filteredProfiles.add(profiles.get(4));
        Mockito.when(matchDAO.getAllProfiles()).thenReturn(profiles);
        Mockito.when(matchSearchFilters.filter(Mockito.anyList(),Mockito.any(MatchSearchCriteria.class))).thenReturn(filteredProfiles);
    }

    @Test
    public void testGetProfiles(){
        criteria = new MatchSearchCriteria();
        criteria.setPhoto(MatchConstants.YES);
        List<Profile> filteredProfiles = matchService.getProfiles(criteria);
        assertNotNull(filteredProfiles);
        assertEquals(2,filteredProfiles.size());
    }

}