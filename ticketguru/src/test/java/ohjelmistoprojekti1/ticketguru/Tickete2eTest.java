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

    // Testataan kaikkien lippujen hakemista
    @Test
    public void testGetAllTickets() throws Exception {
        mockMvc.perform(get("/api/tickets")
                .with(httpBasic("user", "user")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    // Testataan lipun hakemista koodin perusteella
    @Test
    public void testGetTicketByCode() throws Exception {
        mockMvc.perform(get("/api/tickets?code=CODE12345")
                .with(httpBasic("user", "user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("CODE12345"));
    }

    // Testataan lipun tarkistamista (käytetyksi merkitsemistä)
    @Test
    public void testCheckTicket() throws Exception {
        mockMvc.perform(patch("/api/tickets/check/1")
                .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticketUsed").value(true));
    }

    // Testataan lipun poistamista
    @Test
    public void testDeleteTicket() throws Exception {
        mockMvc.perform(delete("/api/tickets/1")
                .with(httpBasic("admin", "admin")))
                .andExpect(status().isNoContent());
    }

    // Testataan olemattoman lipun hakemista
    @Test
    public void testGetNonExistentTicket() throws Exception {
        mockMvc.perform(get("/api/tickets/999")
                .with(httpBasic("user", "user")))
                .andExpect(status().isNotFound());
    }
}