package ohjelmistoprojekti1.ticketguru;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class Tickete2eTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllTickets() throws Exception {
        mockMvc.perform(get("/api/tickets")
                .with(httpBasic("USER", "USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testGetTicketByCode() throws Exception {
        mockMvc.perform(get("/api/tickets?code=CODE12345")
                .with(httpBasic("USER", "USER")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("CODE12345"));
    }

    @Test
    public void testCheckTicket() throws Exception {
        mockMvc.perform(patch("/api/tickets/check/1")
                .with(httpBasic("ADMIN", "ADMIN")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticketUsed").value(true));
    }
}
