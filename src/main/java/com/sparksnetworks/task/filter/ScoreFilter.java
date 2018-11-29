package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class ScoreFilter implements MatchFilter<Profile,MatcherSearchCriteria> {

    @Override
    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria) {
        if(criteria == null || (criteria.getMinScore() == null && criteria.getMaxAge() == null)) return profiles;
        List<Profile> filteredProfiles = new ArrayList<>();

        for (Profile profile : profiles){
            double score = profile.getCompatabilityScore();
            Double minScore = criteria.getMinScore() != null ? Double.parseDouble(criteria.getMinScore())/100 : null;
            Double maxScore = criteria.getMaxScore() != null ? Double.parseDouble(criteria.getMaxScore())/100 : null;
            if(minScore != null && maxScore != null){
                if(score >= minScore && score <= maxScore)
                    filteredProfiles.add(profile);
            } else if(minScore != null && score >= minScore)
                filteredProfiles.add(profile);
            else if(maxScore != null && score <= maxScore)
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
