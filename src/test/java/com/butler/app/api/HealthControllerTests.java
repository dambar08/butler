package com.butler.app.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class HealthControllerTests {

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new HealthController()).build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void healthEndpointReturnsExpectedPayload() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/health"))
            .andExpect(status().isOk())
            .andReturn();

        JsonNode response = objectMapper.readTree(result.getResponse().getContentAsString());

        assertEquals("ok", response.get("status").asText());
        assertEquals("butler", response.get("app").asText());
        assertEquals(3, response.size());
        assertDoesNotThrow(() -> Instant.parse(response.get("timestamp").asText()));
    }
}
