package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class HeightFilter implements MatchFilter<Profile,MatcherSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {
        if(criteria == null || (criteria.getMinHeight() == null && criteria.getMaxHeight() == null)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for (Profile profile : profiles){
            int height = profile.getHeightInCm();
            Integer minHeight = criteria.getMinHeight() != null ? Integer.parseInt(criteria.getMinHeight()) : null;
            Integer maxHeight = criteria.getMaxHeight() != null ? Integer.parseInt(criteria.getMaxHeight()) : null;
            if(minHeight != null && maxHeight != null){
                if(height >= minHeight && height <= maxHeight)
                    filteredProfiles.add(profile);
            } else if(minHeight != null && height >= minHeight)
                filteredProfiles.add(profile);
            else if(maxHeight != null && height <= maxHeight)
                filteredProfiles.add(profile);

        }
        return filteredProfiles;
    }
}
