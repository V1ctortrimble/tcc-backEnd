package com.unicesumar.ads.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.ads.tcc.controller.RecoveryPassController;
import com.unicesumar.ads.tcc.service.RecoveryPassService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RecoveryPassTest {

    private final static String BASE_URL = "http://localhost:8080";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RecoveryPassController recoveryPassController;

    @Test
    void case1() throws Exception{
        String email = "marcio.lesni@gmail.com";

        RecoveryPassService recoveryPassService = new RecoveryPassService();

        mockMvc.perform(post(BASE_URL+"/sendemail")
                .contentType("application/json")
        .content(objectMapper.writeValueAsString(recoveryPassService.recoveryPass(email))))
        .andExpect(status().isOk());

        Assertions.assertTrue(true);

    }
}
