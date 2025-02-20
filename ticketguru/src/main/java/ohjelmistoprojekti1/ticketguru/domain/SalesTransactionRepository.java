package ohjelmistoprojekti1.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTransactionRepository extends CrudRepository<SalesTransaction, Long> { 

}
