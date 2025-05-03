package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;

import ohjelmistoprojekti1.ticketguru.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
