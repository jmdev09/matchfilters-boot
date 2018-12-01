package com.sparksnetworks.task.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 8266157173985925491L;

    private List<Profile> matches;

    public List<Profile> getMatches() {
        return matches;
    }

    public void setMatches(List<Profile> matches) {
        this.matches = matches;
    }
}
