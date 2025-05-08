package ohjelmistoprojekti1.ticketguru;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SalesTransactionRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    // Testataan kaikkien myyntitapahtumien hakemista
    @Test
    public void testGetAllSalesTransactions() throws Exception {
        mockMvc.perform(get("/api/sales")
                .with(httpBasic("user", "user")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    // Testataan myyntitapahtuman hakemista ID:n perusteella
    @Test
    public void testGetSalesTransactionById() throws Exception {
        mockMvc.perform(get("/api/sales/1")
                .with(httpBasic("user", "user")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1));
    }

    // Testataan uuden myyntitapahtuman luomista
    @Test
    public void testCreateSalesTransaction() throws Exception {
        String newTransactionJson = """
            {
                "tickets": [
                    { "eventId": 1, "ticketTypeId": 1, "count": 2 },
                    { "eventId": 1, "ticketTypeId": 2, "count": 1 }
                ]
            }
        """;

        mockMvc.perform(post("/api/sales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newTransactionJson)
                .with(httpBasic("user", "user")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.salesTransactionId").exists());
    }

    // Testataan olemattoman myyntitapahtuman hakemista
    @Test
    public void testGetNonExistentSalesTransaction() throws Exception {
        mockMvc.perform(get("/api/sales/999")
                .with(httpBasic("user", "user")))
                .andExpect(status().isNotFound());
    }

    // Testataan myyntitapahtuman poistamista
    @Test
    public void testDeleteSalesTransaction() throws Exception {
        mockMvc.perform(delete("/api/sales/1")
                .with(httpBasic("admin", "admin")))
                .andExpect(status().isNoContent());
    }
}