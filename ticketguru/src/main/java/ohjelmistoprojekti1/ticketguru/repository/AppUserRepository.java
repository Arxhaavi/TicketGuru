package ohjelmistoprojekti1.ticketguru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ohjelmistoprojekti1.ticketguru.model.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
