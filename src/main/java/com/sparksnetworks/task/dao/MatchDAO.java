package com.sparksnetworks.task.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparksnetworks.task.model.Response;
import com.sparksnetworks.task.model.User;
import com.sparksnetworks.task.model.Response;
import com.sparksnetworks.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Maroju, Jithender on 27/11/18
 */
@Repository
public class MatchDAO {

    @Autowired
    private RestTemplate restTemplate;

    private static final String FETCH_URL ="https://raw.githubusercontent.com/sparknetworks/coding_exercises_options/master/filtering_matches/database/matches.json";
    private static final String FAKE_URL ="https://jsonplaceholder.typicode.com/todos";

    public List<User> getUsers(){
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(FAKE_URL, User[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    public Response getAllProfiles() {
//        ResponseEntity<String> response = restTemplate.getForEntity(FETCH_URL, String.class);
        ResponseEntity<Response> res = restTemplate.getForEntity(FETCH_URL, Response.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Response res = objectMapper.readValue(response.getBody(),Response.class);
        return res.getBody();
    }

    public String getAllProfilesString(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(FETCH_URL, String.class);
        String result = responseEntity.getBody();
        return result;
    }
}
