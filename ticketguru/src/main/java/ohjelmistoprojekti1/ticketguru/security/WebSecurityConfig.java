package ohjelmistoprojekti1.ticketguru.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) 
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER", "ADMIN") // GET kaikille
                .requestMatchers(HttpMethod.POST, "/api/sales/**", "/api/events/**").hasRole("USER") // USER voi POST /api/sales
                .requestMatchers(HttpMethod.PUT, "/api/sales/**", "/api/events/**").hasRole("USER")  // USER voi PUT /api/sales
                .requestMatchers("/api/**").hasRole("ADMIN") // ADMIN voi tehdä mitä vain
                .anyRequest().authenticated()
            );
            http.httpBasic(httpBasic -> httpBasic.realmName("TicketGuru"));
                    return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
   
}