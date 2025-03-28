package ohjelmistoprojekti1.ticketguru.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ohjelmistoprojekti1.ticketguru.domain.AppUser;
import ohjelmistoprojekti1.ticketguru.domain.AppUserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppUserRepository userRepository;
    @SuppressWarnings("unused")
    private final PasswordEncoder passwordEncoder; 

    public UserDetailServiceImpl(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("User found: " + username);
        System.out.println("Hash: " + user.getPasswordHash());
        System.out.println("Role: " + user.getRole());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswordHash(),
                AuthorityUtils.createAuthorityList(user.getRole())
        );
    }
}