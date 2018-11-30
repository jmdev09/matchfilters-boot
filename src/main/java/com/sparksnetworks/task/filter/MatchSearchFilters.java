package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatchSearchCriteria;
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
    private MatchFilter<Profile,MatchSearchCriteria> ageFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> contactFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> favouriteFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> photoFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> heightFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> distanceFilter;

    @Resource
    private MatchFilter<Profile,MatchSearchCriteria> scoreFilter;

    @Resource
    private List<MatchFilter<Profile,MatchSearchCriteria>> filters;

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

    public List<Profile> filter(List<Profile> profiles, MatchSearchCriteria criteria){
        for (MatchFilter filter: filters){
            profiles = filter.filter(profiles,criteria);
        }
        return profiles;
    }
}
