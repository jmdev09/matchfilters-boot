package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.DistanceCalculator;
import com.sparksnetworks.task.util.MatchConstants;
import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.DistanceCalculator;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class DistanceFilter implements MatchFilter<Profile,MatcherSearchCriteria> {


    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {
        if(criteria == null || criteria.getDistance() == null) return profiles;

        if(CollectionUtils.isEmpty(profiles)) return profiles;

        Profile currentUser = profiles.get(1); // simulating the logged in user
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            double distance = DistanceCalculator.distance(currentUser.getCity().getLat(),currentUser.getCity().getLon(),
                    profile.getCity().getLat(),profile.getCity().getLon());
            if(distance <= Double.parseDouble(criteria.getDistance()))
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
