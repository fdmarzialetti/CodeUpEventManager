package com.mindhub.event_manager.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class CustomerEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customerEvent_id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name="eventLocation_id")
    private EventLocation eventLocation;

    public CustomerEvent() {
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public UUID getCustomerEvent_id() {
        return customerEvent_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
