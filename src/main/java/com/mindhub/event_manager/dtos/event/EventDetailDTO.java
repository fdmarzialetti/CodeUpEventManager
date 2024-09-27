package com.mindhub.event_manager.dtos.event;

import com.mindhub.event_manager.models.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class EventDTO {

    private UUID id;
    private String name;
    private byte age_req;
    private String desc;
    private String img;
    private Organizer organizer;
    private Set<Comment> comments = new HashSet<>();
    private Set<EventLocation> eventLocations = new HashSet<>();
    private Set<Reaction> reactions = new HashSet<>();

    public EventDTO(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.desc = event.getDesc();
        this.img = event.getImg();
        this.organizer = event.getOrganizer();
        this.comments = event.getComments();
        this.eventLocations = getEventLocations();
        this.reactions = event.getReactions();
    }
}
