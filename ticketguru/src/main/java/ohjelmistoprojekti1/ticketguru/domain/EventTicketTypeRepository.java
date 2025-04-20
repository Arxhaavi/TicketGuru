package ohjelmistoprojekti1.ticketguru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EventTicketTypeRepository extends CrudRepository<EventTicketType, Long> {
    Optional<EventTicketType> findByEventAndTicketType(Event event, TicketType ticketType);
}