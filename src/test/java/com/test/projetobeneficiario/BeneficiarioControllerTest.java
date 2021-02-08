package com.test.projetobeneficiario;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BeneficiarioControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnSaveOk() throws Exception {
        this.mockMvc.perform(get("/beneficiario")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk() throws Exception {
        this.mockMvc.perform(get("/beneficiario")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequest() throws Exception {
        this.mockMvc.perform(get("/beneficiario/fasdf")).andDo(print()).andExpect(status().isBadRequest());
    }
}

