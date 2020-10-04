package com.unicesumar.ads.tcc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ForgetPassTest {

    private final static String BASE_URL = "http://localhost:8080";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsersService usersService;

    @Test
    void ct0207() throws Exception{

        UsersEntity user = new UsersEntity();
        user.setUsername("teste@teste.com");
        String code = "123412334";
        BDDMockito.when(usersService.getUserChangePass(code)).thenReturn(user);

        mockMvc.perform(get(BASE_URL+"/api/recoverypassword/"+code)
                .contentType("application/json"))
                .andExpect(status().isOk());

        Assertions.assertTrue(true);
    }

    @Test
    void ct0208() throws Exception{

        String code = "12345";

        mockMvc.perform(get(BASE_URL+"/api/recoverypassword/"+code)
                .contentType("application/json"))
                .andExpect(status().isNotFound());

        Assertions.assertTrue(true);
    }



}
