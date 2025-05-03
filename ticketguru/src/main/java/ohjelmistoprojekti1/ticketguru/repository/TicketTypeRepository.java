package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ohjelmistoprojekti1.ticketguru.model.TicketType;

@Repository
public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {

}