package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.MatchConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
@Component
public class FavouriteFilter implements MatchFilter<Profile,MatcherSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {

        if(criteria == null || criteria.getFavourite() == null || criteria.getFavourite().equals(MatchConstants.ALL)) return profiles;

        if(CollectionUtils.isEmpty(profiles)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            if(criteria.getFavourite().equals(MatchConstants.YES) && profile.isFavourite())
                filteredProfiles.add(profile);
            else if(criteria.getFavourite().equals(MatchConstants.NO) && !profile.isFavourite())
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }


}
