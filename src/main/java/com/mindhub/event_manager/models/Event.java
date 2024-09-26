package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private byte age_req;
    private String desc;
    private String img;

    @ManyToOne
    @JoinColumn(name ="organizer_id")
    private Organizer organizer;

    @OneToMany(mappedBy = "event")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventLocation> eventLocations = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Reaction> reactions = new HashSet<>();


    public void addReaction(Reaction reaction){
        reaction.setEvent(this);
        reactions.add(reaction);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        this.eventLocations.add(eventLocation);
    }

}
