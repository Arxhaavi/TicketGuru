package ohjelmistoprojekti1.ticketguru.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ohjelmistoprojekti1.ticketguru.domain.Ticket;
import ohjelmistoprojekti1.ticketguru.domain.TicketRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
    }

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
    

}
