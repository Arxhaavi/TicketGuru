package ohjelmistoprojekti1.ticketguru.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti1.ticketguru.model.AppUser;
import ohjelmistoprojekti1.ticketguru.repository.AppUserRepository;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Tämä luokka vastaa käyttäjätietojen lataamisesta tietokannasta ja niiden muuntamisesta
 * Spring Securityn UserDetails-objektiksi.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository userRepository;
    @SuppressWarnings("unused")
    private final PasswordEncoder passwordEncoder;

     
     
    public UserDetailServiceImpl(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Lataa käyttäjän tiedot käyttäjänimen perusteella.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Debug-tulosteet (poistettavissa tuotantokoodista)
        System.out.println("User found: " + username);
        System.out.println("Hash: " + user.getPasswordHash());
        System.out.println("Role: " + user.getRole());

        // Muunnetaan AppUser-objekti Spring Securityn UserDetails-objektiksi
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswordHash(),
                AuthorityUtils.createAuthorityList(user.getRole()));
    }
}