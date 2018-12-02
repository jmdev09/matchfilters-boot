package com.sparksnetworks.task.integration;

import com.sparksnetworks.task.MatchFiltersApplication;
import com.sparksnetworks.task.controller.RestMatchController;
import com.sparksnetworks.task.model.MatchSearchCriteria;
import com.sparksnetworks.task.model.Profile;
import com.sparksnetworks.task.util.ProfileUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Maroju, Jithender on 02/12/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MatchFiltersIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestMatchController restMatchController;

    @Test
    public void getProfiles() throws Exception {
        List<Profile> profiles = ProfileUtility.getProfiles();
        BDDMockito.given(restMatchController.home(Mockito.any(MatchSearchCriteria.class))).willReturn(profiles);

        this.mockMvc.perform(get("/results"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].display_name", is("Caroline")))
                .andExpect(jsonPath("$[1].display_name", is("Sharon")))
                .andExpect(jsonPath("$[4].age", is(39)))
                .andExpect(jsonPath("$.*", hasSize(5)));
    }


}
