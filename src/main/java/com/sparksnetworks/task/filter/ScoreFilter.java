package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.FieldUtils.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.sparksnetworks.task.util.FieldUtils.isNotNull;
import static com.sparksnetworks.task.util.FieldUtils.isNull;

/*
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class ScoreFilter implements MatchFilter<Profile,MatchSearchCriteria> {

    public ScoreFilter(){
        System.out.println("Hello");
    }

    @Override
    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria) {
        if(isNull(criteria) || isNull(criteria.getMinScore(),criteria.getMaxScore())) return profiles;

        Double minScore = criteria.getMinScore() != null ? criteria.getMinScore()/100 : null;
        Double maxScore = criteria.getMaxScore() != null ? criteria.getMaxScore()/100 : null;

        if(minScore != null && maxScore != null && minScore > maxScore) return profiles;

        List<Profile> filteredProfiles = new ArrayList<>();
        for (Profile profile : profiles){
            double score = profile.getCompatabilityScore();
            if(isNotNull(minScore,maxScore)){
                if(score >= minScore && score <= maxScore)
                    filteredProfiles.add(profile);
            } else if(isNotNull(minScore) && score >= minScore)
                filteredProfiles.add(profile);
            else if(isNotNull(maxScore) && score <= maxScore)
                filteredProfiles.add(profile);
        }
        return filteredProfiles;
    }
}
