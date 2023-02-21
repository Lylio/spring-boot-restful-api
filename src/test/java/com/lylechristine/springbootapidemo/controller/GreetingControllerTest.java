package com.lylechristine.springbootapidemo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Lyle Christine
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    This code defines two unit tests for the "GreetingController" class. The first test checks that the default
    message is returned when no name is provided. The second test checks that a custom message is returned when a
    name is provided.
    */

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    public void shouldReturnCustomMessage() throws Exception {
        String name = "Alice";
        this.mockMvc.perform(get("/greeting").param("name", name)).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + name + "!")));

    }
}
