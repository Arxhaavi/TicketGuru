package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ohjelmistoprojekti1.ticketguru.model.SalesTransaction;

@Repository
public interface SalesTransactionRepository extends CrudRepository<SalesTransaction, Long> {

}
