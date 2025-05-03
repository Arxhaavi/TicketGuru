package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti1.ticketguru.model.Postalcode;

public interface PostalcodeRepository extends CrudRepository<Postalcode, String> {

}
