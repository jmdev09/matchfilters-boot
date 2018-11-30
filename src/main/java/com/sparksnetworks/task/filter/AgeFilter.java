package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.FieldUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.sparksnetworks.task.util.FieldUtils.getValue;
import static com.sparksnetworks.task.util.FieldUtils.isNotNull;
import static com.sparksnetworks.task.util.FieldUtils.isNull;

/**
 * @author Maroju, Jithender on 27/11/18
 */

@Component
public class AgeFilter implements MatchFilter<Profile,MatchSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {

        if(isNull(criteria) || isNull(criteria.getMinAge(),criteria.getMaxAge())) return profiles;

        Integer minAge = getValue(criteria.getMinAge());
        Integer maxAge = getValue(criteria.getMaxAge());
        if(isNotNull(minAge,maxAge) && minAge > maxAge) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for (Profile profile : profiles){
            int age = profile.getAge();
            if(isNotNull(minAge,maxAge)){
                if(age >= minAge && age <= maxAge)
                    filteredProfiles.add(profile);
            } else if(isNotNull(minAge) && age >= minAge)
                filteredProfiles.add(profile);
            else if(isNotNull(maxAge) && age <= maxAge)
                filteredProfiles.add(profile);

        }
        return filteredProfiles;
    }
}
