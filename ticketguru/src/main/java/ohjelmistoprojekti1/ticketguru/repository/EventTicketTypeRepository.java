package ohjelmistoprojekti1.ticketguru.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti1.ticketguru.model.Event;
import ohjelmistoprojekti1.ticketguru.model.EventTicketType;
import ohjelmistoprojekti1.ticketguru.model.TicketType;

public interface EventTicketTypeRepository extends CrudRepository<EventTicketType, Long> {
    Optional<EventTicketType> findByEventAndTicketType(Event event, TicketType ticketType);
}