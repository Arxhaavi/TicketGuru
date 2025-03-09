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

@SpringBootApplication
public class TicketguruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(LocationRepository locationRepository, EventRepository eventRepository,
			PostalcodeRepository postalcodeRepository, TicketTypeRepository ticketTypeRepository, TicketRepository ticketRepository) {
		return (args) -> {

			Postalcode postalcode = new Postalcode("33100", "Tampere", "Suomi");
			postalcodeRepository.save(postalcode);

			Location location = new Location("Tampere Arena", "Hämeenkatu 30, Tampere", postalcode, 5000);
			locationRepository.save(location);

			Event event = new Event("Jalkapallo-ottelu", "Suomen maajoukkueen peli",
					java.time.LocalDate.of(2025, 6, 15), java.time.LocalDate.of(2025, 6, 15),
					location, 2000);
			eventRepository.save(event);

			TicketType ticketType1 = new TicketType("Eläkeläinen");
            TicketType ticketType2 = new TicketType("Opiskelija");
            ticketTypeRepository.save(ticketType1);
            ticketTypeRepository.save(ticketType2);

			Ticket ticket1 = new Ticket(ticketType1, event, false, 100.0);
			Ticket ticket2 = new Ticket(ticketType2, event, false, 120.0);
			ticketRepository.save(ticket1);
            ticketRepository.save(ticket2);

			System.out.println("Testidataa lisätty:");
			System.out.println(location);
			System.out.println(event);
			System.out.println(ticketType1);
            System.out.println(ticketType2);
            System.out.println(ticket1);
            System.out.println(ticket2);
		};
	}

}
