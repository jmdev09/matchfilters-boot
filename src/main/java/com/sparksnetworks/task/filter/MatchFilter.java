package com.sparksnetworks.task.filter;

import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */

public interface MatchFilter<T,K> {

     List<T> filter(List<T> list, K criteria);
}
