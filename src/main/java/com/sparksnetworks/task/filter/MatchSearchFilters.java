package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 28/11/18
 */
@Component
public class MatchSearchFilters {

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> ageFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> contactFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> favouriteFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> photoFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> heightFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> distanceFilter;

    @Resource
    private MatchFilter<Profile,MatcherSearchCriteria> scoreFilter;

    @Resource
    private List<MatchFilter<Profile,MatcherSearchCriteria>> filters;

    @PostConstruct
    public void init(){
        filters = new ArrayList<>();
        filters.add(distanceFilter);
        filters.add(ageFilter);
        filters.add(contactFilter);
        filters.add(favouriteFilter);
        filters.add(photoFilter);
        filters.add(heightFilter);
        filters.add(scoreFilter);
    }

    public List<Profile> filter(List<Profile> profiles, MatcherSearchCriteria criteria){
        for (MatchFilter filter: filters){
            profiles = filter.filter(profiles,criteria);
        }
        return profiles;
    }
}
