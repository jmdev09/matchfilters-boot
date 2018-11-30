package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.FieldUtils;
import com.sparksnetworks.task.util.MatchConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.sparksnetworks.task.util.FieldUtils.*;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Component
public class ContactFilter implements MatchFilter<Profile,MatchSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {

        if(isNull(criteria) || isNull(criteria.getInContact()) || criteria.getInContact().equals(MatchConstants.ALL)) return profiles;

        if(CollectionUtils.isEmpty(profiles)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for(Profile profile : profiles){
            if(MatchConstants.YES.equals(criteria.getInContact())){
                if(profile.getContactsExchanged() > 0)
                    filteredProfiles.add(profile);
            } else if(profile.getContactsExchanged() == 0)
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
