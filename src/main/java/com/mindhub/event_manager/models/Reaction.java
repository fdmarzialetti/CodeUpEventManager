package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reaction{
    @EmbeddedId
    private ReactionId reactionId;

    @ManyToOne
    @MapsId("eventId")
    private Event event;

    @ManyToOne
    @MapsId("customerId")
    private Customer customer;

    public Reaction(Event event, Customer customer) {
        this.event = event;
        this.customer = customer;
        this.reactionId = new ReactionId(event.getEventId(),customer.getCustomerId());
    }

}
