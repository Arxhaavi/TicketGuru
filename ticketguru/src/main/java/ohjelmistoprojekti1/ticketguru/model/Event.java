package ohjelmistoprojekti1.ticketguru.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long event_id;

    @NotNull(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Start time is mandatory")
    @FutureOrPresent(message = "Start time must be in the future or present")
    @Column(name = "starttime")
    private LocalDateTime startTime;

    @NotNull(message = "End time is mandatory")
    @Column(name = "endtime")
    private LocalDateTime endTime;

    @AssertTrue(message = "End time must be after start time")
    public boolean isEndTimeAfterStartTime() {
        return endTime == null || startTime == null || endTime.isAfter(startTime);
    }

    @NotNull(message = "Location is mandatory")
    @Valid
    @ManyToOne
    @JoinColumn(name = "locationid")
    private Location location;

    @NotNull(message = "Ticket count is mandatory")
    @Min(value = 1, message = "Ticket count must be at least 1")
    @Column(name = "ticketcount")
    private Integer ticketCount;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventTicketType> eventTicketTypes = new ArrayList<>();

    public Event() {

    }

    public Event(String name, String description, LocalDateTime startTime, LocalDateTime endTime, Location location,
            Integer ticketCount) {
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<EventTicketType> getEventTicketTypes() {
        return eventTicketTypes;
    }

    public void setEventTicketTypes(List<EventTicketType> eventTicketTypes) {
        this.eventTicketTypes = eventTicketTypes;
    }

    @Override
    public String toString() {
        return "Event [id=" + event_id + ", name=" + name + ", description=" + description + ", startTime=" + startTime
                + ", endTime=" + endTime + ", location=" + location + ", ticketCount=" + ticketCount + "]";
    }

}
