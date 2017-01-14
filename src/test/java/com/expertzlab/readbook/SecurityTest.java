package com.expertzlab.readbook;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by gireeshbabu on 10/01/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SecurityTest {

    @Autowired
    private WebApplicationContext webContext;
    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void homePage_unauthenticatedUser() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location",
                        "http://localhost/login"));
    }

    @WithMockUser(username="craig",
            password="password",
            roles="READER")
    @Test
    public void homePage_authenticatedUser() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithUserDetails(value = "giri")
    public void homePage_authenticatedUser_user() throws Exception {
       /* Reader expectedReader = new Reader();
        expectedReader.setUsername("giri");
        expectedReader.setPassword("giri");
        expectedReader.setFullname("giri");
        */
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

}
