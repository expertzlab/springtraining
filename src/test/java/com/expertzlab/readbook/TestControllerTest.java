package com.expertzlab.readbook;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by gireeshbabu on 24/01/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void myMethod() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/test/mymethod")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"author\":\"My Name\",\"reader\":\"My Reader\"," +
                        "\"title\":null,\"isbn\":null,\"description\":null,\"reviewers\":null}"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
