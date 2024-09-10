package com.mindhub.event_manager.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class EventLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventLocation_id;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @OneToMany(mappedBy = "eventLocation")
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    private LocalDateTime date;
    private int assistance;

    public EventLocation() {
    }

    public void addCustomerEvent(CustomerEvent customerEvent){
        customerEvent.setEventLocation(this);
        this.customerEvents.add(customerEvent);
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public void setCustomerEvents(Set<CustomerEvent> customerEvents) {
        this.customerEvents = customerEvents;
    }

    public UUID getEventLocation_id() {
        return eventLocation_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAssistance() {
        return assistance;
    }

    public void setAssistance(int assistance) {
        this.assistance = assistance;
    }
}
