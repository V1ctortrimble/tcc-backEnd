package com.unicesumar.ads.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
    private final static String BASE_URL = "http://localhost:8080";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void ct0101() throws Exception{

        JSONObject jsonObject = new JSONObject("{\"username\":\"guto_rick1997@hotmail.com\",\"password\":\"Teste157#@!\"}");

        mockMvc.perform(post(BASE_URL+"/login")
                .contentType("application/json")
                .content(jsonObject.toString()))
                .andExpect(status().isOk());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0102() throws Exception{

        JSONObject jsonObject = new JSONObject("{\"username\":\"guto_rick1997@hotmail.com\",\"password\":\"\"}");

        mockMvc.perform(post(BASE_URL+"/login")
                .contentType("application/json")
                .content(jsonObject.toString()))
                .andExpect(status().isUnauthorized());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0103() throws Exception{

        JSONObject jsonObject = new JSONObject("{\"username\":\"teste@teste.com\",\"password\":\"teste\"}");

        mockMvc.perform(post(BASE_URL+"/login")
                .contentType("application/json")
                .content(jsonObject.toString()))
                .andExpect(status().isUnauthorized());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0104() throws Exception{

        JSONObject jsonObject = new JSONObject("{\"username\":\"teste@teste.com\",\"password\":\"Teste157#@!\"}");

        mockMvc.perform(post(BASE_URL+"/login")
                .contentType("application/json")
                .content(jsonObject.toString()))
                .andExpect(status().isUnauthorized());

        Assertions.assertTrue(true);
    }
}
