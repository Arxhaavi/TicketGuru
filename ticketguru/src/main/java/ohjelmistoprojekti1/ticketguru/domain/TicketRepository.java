package ohjelmistoprojekti1.ticketguru.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    boolean existsByEventId(Long eventId);

    Optional<Ticket> findByCode(String code);

    boolean existsByCode(String code);
}
