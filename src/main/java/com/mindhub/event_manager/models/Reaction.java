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
    /*
    @EmbeddedId
    private ReactionId reactionId;
    public Reaction(Event event, Customer customer) {
        this.event = event;
        this.customer = customer;
        this.reactionId = new ReactionId(event.getEventId(),customer.getCustomerId());
    }
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reactionId;

    private ReactionType reactionType;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

}
