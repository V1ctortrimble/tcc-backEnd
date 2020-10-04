package com.unicesumar.ads.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.ads.tcc.controller.RecoveryPassController;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.service.RecoveryPassService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
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

    @MockBean
    private RecoveryPassService recoveryPassService;

    @Test
    void case1() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("marcio.lesni@gmail.com");

        BDDMockito.when((recoveryPassService.recoveryPass(usersDTO.getUsername()))).thenReturn("OK");

        mockMvc.perform(post(BASE_URL+"/api/sendemail")
                .contentType("application/json")
        .content(objectMapper.writeValueAsString(usersDTO)))
        .andExpect(status().isOk());

        Assertions.assertTrue(true);
    }

    @Test
    void case2() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("");

        BDDMockito.when((recoveryPassService.recoveryPass(usersDTO.getUsername()))).thenThrow();

        mockMvc.perform(post(BASE_URL+"/api/sendemail")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isBadRequest());

        Assertions.assertTrue(true);

    }
}
