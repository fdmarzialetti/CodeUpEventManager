package com.mindhub.event_manager.models;
import com.mindhub.event_manager.enums.ReactionType;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reaction{

    @EmbeddedId
    private ReactionId reactionId;

    @ManyToOne
    @JoinColumn(name= "event_id",insertable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable = false, updatable = false)
    private Customer customer;

    private ReactionType reactionType;

    public Reaction(Event event, Customer customer){
        this.event = event;
        this.customer = customer;
        reactionId = new ReactionId(event.getEventId(),customer.getCustomerId());
    }

}
