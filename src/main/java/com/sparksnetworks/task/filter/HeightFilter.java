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
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class HeightFilter implements MatchFilter<Profile,MatchSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {
        if(isNull(criteria) || isNull(criteria.getMinHeight(),criteria.getMaxHeight())) return profiles;

        Integer minHeight = getValue(criteria.getMinHeight());
        Integer maxHeight = getValue(criteria.getMaxHeight());

        if(isNotNull(minHeight,maxHeight) && minHeight > maxHeight) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();
        for (Profile profile : profiles){
            int height = profile.getHeightInCm();
            if(isNotNull(minHeight,maxHeight)){
                if(height >= minHeight && height <= maxHeight)
                    filteredProfiles.add(profile);
            } else if(isNotNull(minHeight) && height >= minHeight)
                filteredProfiles.add(profile);
            else if(isNotNull(maxHeight) && height <= maxHeight)
                filteredProfiles.add(profile);

        }
        return filteredProfiles;
    }
}
