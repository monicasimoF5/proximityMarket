package org.msc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.msc.dtos.FarmerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FarmerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    @Test
    public void should_createAFarmer_whenValidRequestIsSent() throws Exception {

        FarmerRequest farmerRequest = new FarmerRequest("farmer1", "123456789", "farmer1@market.com", "address1");
        String jsonRequest = asJsonString(farmerRequest);

        // Simulación de la petición POST
        mockMvc.perform(post("/farmers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))

                // Verificación de la respuesta
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(farmerRequest.name()))
                .andExpect(jsonPath("$.phone").value(farmerRequest.phone()))
                .andExpect(jsonPath("$.email").value(farmerRequest.email()))
                .andExpect(jsonPath("$.address").value(farmerRequest.address()));
    }

    /*@MockBean
    private FarmerService farmerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_getFarmerById_whenNameIsNumeric() throws Exception {
        Long farmerId = 1L;
        Farmer farmer = new Farmer(farmerId, "John Doe", "123456789", "john.doe@example.com", "Main St 123");
        Mockito.when(farmerService.findById(anyLong())).thenReturn(farmer);

        mockMvc.perform(get("/farmers/" + farmerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(farmerId.intValue()));
    }*/


}