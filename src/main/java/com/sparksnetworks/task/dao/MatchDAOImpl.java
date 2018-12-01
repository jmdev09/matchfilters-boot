package com.sparksnetworks.task.dao;

import com.sparksnetworks.task.controller.RestMatchController;
import com.sparksnetworks.task.model.*;
import com.sparksnetworks.task.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
@Repository
public class MatchDAOImpl implements MatchDAO {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${data.fetch.url}")
    private String FETCH_URL;

    private static final Logger logger = LoggerFactory.getLogger(MatchDAOImpl.class);

    @Override
    public List<Profile> getAllProfiles() {
        ResponseEntity<Response> responseEntity = restTemplate.getForEntity(FETCH_URL, Response.class);
        Response response = responseEntity.getBody();
        List<Profile> profiles = response.getMatches() != null ? response.getMatches() : new ArrayList<>();
        return profiles;
    }
}
