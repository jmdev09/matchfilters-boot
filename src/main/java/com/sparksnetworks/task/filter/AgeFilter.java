package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Component
public class AgeFilter implements MatchFilter<Profile,MatcherSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {

        if(criteria == null || (criteria.getMinAge() == null && criteria.getMaxAge() == null)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for (Profile profile : profiles){
            int age = profile.getAge();
            Integer minAge = criteria.getMinAge();
            Integer maxAge = criteria.getMaxAge();
            if(minAge != null && maxAge != null){
                if(age >= minAge && age <= maxAge)
                    filteredProfiles.add(profile);
            } else if(minAge != null && age >= minAge)
                filteredProfiles.add(profile);
            else if(maxAge != null && age <= maxAge)
                filteredProfiles.add(profile);

        }
        return filteredProfiles;
    }
}
