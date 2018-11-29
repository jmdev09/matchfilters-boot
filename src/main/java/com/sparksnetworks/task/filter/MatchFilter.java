package com.sparksnetworks.task.filter;

import com.sparksnetworks.task.model.MatcherSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

public interface MatchFilter<T,K> {

     List<T> filter(List<T> list, K criteria);
}
