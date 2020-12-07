package com.unicesumar.ads.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.ads.tcc.controller.RecoveryPassController;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import com.unicesumar.ads.tcc.dto.UsersDTO;
import com.unicesumar.ads.tcc.service.RecoveryPassService;
import com.unicesumar.ads.tcc.service.UsersService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    void ct0201() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("guto_rick1997@hotmail.com");

        mockMvc.perform(post(BASE_URL+"/api/sendemail") 
                .contentType("application/json")
        .content(objectMapper.writeValueAsString(usersDTO)))
        .andExpect(status().isOk());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0202() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("");

        mockMvc.perform(post(BASE_URL+"/api/sendemail")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isBadRequest());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0203() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("guto_rick1997@hotmail.com");
        usersDTO.setPassword("Teste157#@!");
        usersDTO.setRepeatPassword("Teste157#@!");

        mockMvc.perform(put(BASE_URL+"/api/changepassword")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isOk());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0204() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("guto_rick1997@hotmail.com");
        usersDTO.setPassword("Teste157#@!");
        usersDTO.setRepeatPassword("Teste1#@!");

        mockMvc.perform(put(BASE_URL+"/api/changepassword")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isBadRequest());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0205() throws Exception{

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername("guto_rick1997@hotmail.com");
        usersDTO.setPassword("testeteste");
        usersDTO.setRepeatPassword("testeteste");

        mockMvc.perform(put(BASE_URL+"/api/changepassword")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isBadRequest());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0206() throws Exception{

        UsersDTO usersDTO = new UsersDTO();

        mockMvc.perform(put(BASE_URL+"/api/changepassword")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(usersDTO)))
                .andExpect(status().isNotFound());

        Assertions.assertTrue(true);
    }


}
