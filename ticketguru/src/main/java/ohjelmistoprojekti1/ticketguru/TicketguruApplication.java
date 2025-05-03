package ohjelmistoprojekti1.ticketguru;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import ohjelmistoprojekti1.ticketguru.model.AppUser;
import ohjelmistoprojekti1.ticketguru.model.Event;
import ohjelmistoprojekti1.ticketguru.model.EventTicketType;
import ohjelmistoprojekti1.ticketguru.model.Location;
import ohjelmistoprojekti1.ticketguru.model.Postalcode;
import ohjelmistoprojekti1.ticketguru.model.Ticket;
import ohjelmistoprojekti1.ticketguru.model.TicketType;
import ohjelmistoprojekti1.ticketguru.repository.AppUserRepository;
import ohjelmistoprojekti1.ticketguru.repository.EventRepository;
import ohjelmistoprojekti1.ticketguru.repository.EventTicketTypeRepository;
import ohjelmistoprojekti1.ticketguru.repository.LocationRepository;
import ohjelmistoprojekti1.ticketguru.repository.PostalcodeRepository;
import ohjelmistoprojekti1.ticketguru.repository.TicketRepository;
import ohjelmistoprojekti1.ticketguru.repository.TicketTypeRepository;

@SpringBootApplication
public class TicketguruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(LocationRepository locationRepository, EventRepository eventRepository,
			PostalcodeRepository postalcodeRepository, TicketTypeRepository ticketTypeRepository,
			TicketRepository ticketRepository, AppUserRepository userRepository,
			EventTicketTypeRepository eventTicketTypeRepository, PasswordEncoder passwordEncoder) {
		return (args) -> {

			Postalcode postalcode = new Postalcode("33100", "Tampere", "Suomi");
			postalcodeRepository.save(postalcode);

			Location location = new Location("Tampere Arena", "Hämeenkatu 30, Tampere",
					postalcode, 5000);
			locationRepository.save(location);

			Event event1 = new Event("Jalkapallo-ottelu", "Suomen maajoukkueen peli",
					java.time.LocalDateTime.of(2025, 6, 15, 18, 15, 0),
					java.time.LocalDateTime.of(2025, 6, 15, 20, 15, 0),
					location, 2000);

			Event event2 = new Event("Super gaala", "Juhlagaala",
					java.time.LocalDateTime.of(2025, 6, 15, 18, 0, 0),
					java.time.LocalDateTime.of(2025, 6, 15, 21, 0, 0), location, 500);

			eventRepository.save(event1);
			eventRepository.save(event2);

			TicketType ticketType1 = new TicketType("Eläkeläinen");
			TicketType ticketType2 = new TicketType("Opiskelija");
			ticketTypeRepository.save(ticketType1);
			ticketTypeRepository.save(ticketType2);

			Ticket ticket1 = new Ticket(ticketType1, event1, false, "CODE12345");
			Ticket ticket2 = new Ticket(ticketType2, event1, false, "CODE67890");
			ticketRepository.save(ticket1);
			ticketRepository.save(ticket2);

			AppUser user1 = new AppUser("user",
					"$2a$10$4XXGNu904amNx2Q0tPL4OOZiLP012ULGVI2a8Em4SAJGCtQG1WBJu",
					"ROLE_USER"); // password: user
			AppUser user2 = new AppUser("admin",
					"$2a$10$YAvqdDch33w5BecjHl6WP.LjpNaYy9jQlTcE.Krl3ib7VvzRiKUta",
					"ROLE_ADMIN"); // password: admin
			userRepository.save(user1);
			userRepository.save(user2);

			System.out.println("Test data added to PostgreSQL:");
			System.out.println(event1);
			System.out.println(ticketType2);
			System.out.println(ticket1);
			System.out.println(ticket2);

			EventTicketType eventTicketType1 = new EventTicketType(event1, ticketType1,
					120);
			EventTicketType eventTicketType2 = new EventTicketType(event1, ticketType2,
					150);
			eventTicketTypeRepository.save(eventTicketType1);
			eventTicketTypeRepository.save(eventTicketType2);

			/*
			 * AppUser user1 = new AppUser("user",
			 * "$2a$10$4XXGNu904amNx2Q0tPL4OOZiLP012ULGVI2a8Em4SAJGCtQG1WBJu",
			 * "ROLE_USER"); // password: user
			 * AppUser user2 = new AppUser("admin",
			 * "$2a$10$YAvqdDch33w5BecjHl6WP.LjpNaYy9jQlTcE.Krl3ib7VvzRiKUta",
			 * "ROLE_ADMIN"); // password: admin
			 * userRepository.save(user1);
			 * userRepository.save(user2);
			 * 
			 * System.out.println("Test data added to PostgreSQL:");
			 * System.out.println(event1);
			 * System.out.println(ticketType2);
			 * System.out.println(ticket1);
			 * System.out.println(ticket2);
			 */

		};
	}
}