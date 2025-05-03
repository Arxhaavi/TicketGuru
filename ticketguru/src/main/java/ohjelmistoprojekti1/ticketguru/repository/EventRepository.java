package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti1.ticketguru.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
