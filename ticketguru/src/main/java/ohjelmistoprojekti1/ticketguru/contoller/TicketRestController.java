package ohjelmistoprojekti1.ticketguru.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti1.ticketguru.model.Ticket;
import ohjelmistoprojekti1.ticketguru.repository.TicketRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketRestController {

    @Autowired
    private TicketRepository ticketRepository;

    // Hae kaikki liput
    @GetMapping
    public ResponseEntity<Iterable<Ticket>> getTickets() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }

    // Hae lippu koodin perusteella
    @GetMapping(params = "code")
    public ResponseEntity<Ticket> getTicketByCode(@RequestParam String code) {
        Optional<Ticket> ticket = ticketRepository.findByCode(code);
        if (ticket.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ticket.get());
    }

    // Hae lippu ID:n perusteella
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
    }

    // Merkitse lippu käytetyksi
    @PatchMapping("/check/{id}")
    public Ticket checkTicket(@PathVariable Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        if (optionalTicket.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }

        Ticket ticket = optionalTicket.get();

        if (ticket.isTicketUsed()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket has already been used");
        }

        ticket.setTicketUsed(true);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }
    }
}