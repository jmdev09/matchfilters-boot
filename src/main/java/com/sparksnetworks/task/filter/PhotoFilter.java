package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.MatchConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
@Component
public class PhotoFilter implements MatchFilter<Profile,MatchSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {

        if(criteria == null || criteria.getPhoto() == null || criteria.getPhoto().equals(MatchConstants.ALL)) return profiles;

        if(CollectionUtils.isEmpty(profiles)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            if(criteria.getPhoto().equals(MatchConstants.YES)){
                if(StringUtils.isNotEmpty(profile.getMainPhoto()))
                    filteredProfiles.add(profile);
            } else if(StringUtils.isEmpty(profile.getMainPhoto()))
                filteredProfiles.add(profile);


        }
        return filteredProfiles;
    }
}
