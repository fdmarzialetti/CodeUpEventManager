package com.mindhub.event_manager.models;
import com.mindhub.event_manager.enums.ReactionType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reaction{

    @EmbeddedId
    private ReactionId id;

    @ManyToOne
    @JoinColumn(name= "event_id",insertable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private AppUser appUser;

    private ReactionType reactionType;

    public Reaction(Event event, AppUser appUser){
        this.event = event;
        this.appUser = appUser;
        id = new ReactionId(event.getId(), appUser.getId());
    }

}
