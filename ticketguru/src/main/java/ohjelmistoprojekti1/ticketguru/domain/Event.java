package ohjelmistoprojekti1.ticketguru.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long event_id;

    private String name, description;
    private LocalDate startTime;
    private LocalDate endTime;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private int ticketCount;

    public Event() {

    }

    public Event(String name, String description, LocalDate startTime, LocalDate endTime, Location location,
            int ticketCount, Ticket ticket) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.ticketCount = ticketCount;
    }

    public Long getEvent_Id() {
        return event_id;
    }

    public void setId(Long event_id) {
        this.event_id = event_id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void SetTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Event [id=" + event_id + ", name=" + name + ", description=" + description + ", startTime=" + startTime
                + ", endTime=" + endTime + ", location=" + location + ", ticketCount=" + ticketCount + "]";
    }

}
