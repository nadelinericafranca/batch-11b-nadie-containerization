package com.example.tdd.controller;

import com.example.tdd.service.ParcelCostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ParcelCostRestController.class)
public class ParcelCostRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ParcelCostService parcelCostService;

    @Test
    public void testCase_TC120() throws Exception {
        String expectedErrorMessage = "Length is missing";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("w", "10")
                        .param("h", "10"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }

    @Test
    public void testCase_TC130() throws Exception {
        String expectedErrorMessage = "Width is missing";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("l", "10")
                        .param("h", "10"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }

    @Test
    public void testCase_TC140() throws Exception {
        String expectedErrorMessage = "Height is missing";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("l", "10")
                        .param("w", "10"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }

    @Test
    public void testCase_TC150() throws Exception {
        String expectedErrorMessage = "Invalid value for Length";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("l", "a")
                        .param("w", "10")
                        .param("h", "10"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }

    @Test
    public void testCase_TC160() throws Exception {
        String expectedErrorMessage = "Invalid value for Width";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("l", "10")
                        .param("w", "a")
                        .param("h", "10"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }

    @Test
    public void testCase_TC170() throws Exception {
        String expectedErrorMessage = "Invalid value for Height";

        mockMvc.perform(MockMvcRequestBuilders.get("/parcel-cost-api/v1")
                        .param("l", "10")
                        .param("w", "10")
                        .param("h", "a"))
                .andExpect(status().isBadRequest())  // HTTP Status 400
                .andExpect(jsonPath("$.error").value(expectedErrorMessage));
    }
}
