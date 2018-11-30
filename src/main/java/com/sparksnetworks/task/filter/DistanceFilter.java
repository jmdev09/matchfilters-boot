package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.DistanceCalculator;
import com.sparksnetworks.task.util.MatchConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class DistanceFilter implements MatchFilter<Profile,MatchSearchCriteria> {


    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {

        if(criteria == null || criteria.getDistance() == null) return profiles;
        if(CollectionUtils.isEmpty(profiles)) return profiles;
        Profile currentProfile = profiles.get(MatchConstants.LOGGEDIN_PROFILE_INDEX); // simulating the logged in user
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            double distance = DistanceCalculator.distance(currentProfile, profile);
            if(distance <= criteria.getDistance())
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
