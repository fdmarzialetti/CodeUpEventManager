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

    @Id
    @Setter(AccessLevel.NONE)
    private String reactionId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private ReactionType reactionType;

    public Reaction(Event event, Customer customer){
        this.event = event;
        this.customer = customer;
        reactionId = event.getEventId().toString()+"_"+customer.getCustomerId().toString();
    }

}
