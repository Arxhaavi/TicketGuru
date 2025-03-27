package ohjelmistoprojekti1.ticketguru;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti1.ticketguru.domain.Event;
import ohjelmistoprojekti1.ticketguru.domain.EventRepository;
import ohjelmistoprojekti1.ticketguru.domain.Location;
import ohjelmistoprojekti1.ticketguru.domain.LocationRepository;
import ohjelmistoprojekti1.ticketguru.domain.Postalcode;
import ohjelmistoprojekti1.ticketguru.domain.PostalcodeRepository;
import ohjelmistoprojekti1.ticketguru.domain.Ticket;
import ohjelmistoprojekti1.ticketguru.domain.TicketRepository;
import ohjelmistoprojekti1.ticketguru.domain.TicketType;
import ohjelmistoprojekti1.ticketguru.domain.TicketTypeRepository;
import ohjelmistoprojekti1.ticketguru.domain.User;
import ohjelmistoprojekti1.ticketguru.domain.UserRepository;

@SpringBootApplication
public class TicketguruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(LocationRepository locationRepository, EventRepository eventRepository,
			PostalcodeRepository postalcodeRepository, TicketTypeRepository ticketTypeRepository,
			TicketRepository ticketRepository, UserRepository userRepository) {
		return (args) -> {

			// Luo testidatan H2-tietokantaan
			// Luo postinumero
			Postalcode postalcode = new Postalcode("33100", "Tampere", "Suomi");
			postalcodeRepository.save(postalcode);

			// Luo sijainti
			Location location = new Location("Tampere Arena", "Hämeenkatu 30, Tampere", postalcode, 5000);
			locationRepository.save(location);

			// Luo tapahtumat
			Event event1 = new Event("Jalkapallo-ottelu", "Suomen maajoukkueen peli",
					java.time.LocalDateTime.of(2025, 6, 15, 18,15, 0), java.time.LocalDateTime.of(2025, 6, 15, 20, 15, 0),
					location, 2000);

			Event event2 = new Event("Super gaala", "Juhlagaala", java.time.LocalDateTime.of(2025, 6, 15, 18, 0, 0),
					java.time.LocalDateTime.of(2025, 6, 15, 21, 0, 0), location, 500);

			eventRepository.save(event1);
			eventRepository.save(event2);

			// Luo lipputyypit
			TicketType ticketType1 = new TicketType("Eläkeläinen");
			TicketType ticketType2 = new TicketType("Opiskelija");
			ticketTypeRepository.save(ticketType1);
			ticketTypeRepository.save(ticketType2);

			// Luo esimerkkiliput
			Ticket ticket1 = new Ticket(ticketType1, event1, false, 100.0);
			Ticket ticket2 = new Ticket(ticketType2, event1, false, 120.0);
			ticketRepository.save(ticket1);
			ticketRepository.save(ticket2);

			User user1 = new User("admin", "$2a$10$YAvqdDch33w5BecjHl6WP.LjpNaYy9jQlTcE.Krl3ib7VvzRiKUta", "ADMIN");
			User user2 = new User("user", "$2a$10$4XXGNu904amNx2Q0tPL4OOZiLP012ULGVI2a8Em4SAJGCtQG1WBJu", "USER");
			userRepository.save(user1);
			userRepository.save(user2);

			System.out.println("Testidataa lisätty:");
			System.out.println(location);
			System.out.println(event1);
			System.out.println(event2);
			System.out.println(ticketType1);
			System.out.println(ticketType2);
			System.out.println(ticket1);
			System.out.println(ticket2);
		};
	}

}
