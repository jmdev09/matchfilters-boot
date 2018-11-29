package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.MatchConstants;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Component
public class ContactFilter implements MatchFilter<Profile,MatcherSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {

        if(criteria == null || criteria.getContact() == null || criteria.getContact().equals(MatchConstants.ALL)) return profiles;

        if(CollectionUtils.isEmpty(profiles)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            if(MatchConstants.YES.equals(criteria.getContact())){
                if(profile.getContactsExcahnged() > 0)
                    filteredProfiles.add(profile);
            } else if(profile.getContactsExcahnged() == 0)
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
