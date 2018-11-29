package com.sparksnetworks.task.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
public class Response implements Serializable {

    private List<Profile> matches;

    public List<Profile> getMatches() {
        return matches;
    }

    public void setMatches(List<Profile> matches) {
        this.matches = matches;
    }
}
