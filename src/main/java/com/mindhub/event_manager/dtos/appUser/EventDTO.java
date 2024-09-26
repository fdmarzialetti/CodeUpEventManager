package com.mindhub.event_manager.dtos.appUser;

import com.mindhub.event_manager.models.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class EventDTO {

    private UUID id;
    private String name;
    private byte age_req;
    private String desc;
    private String img;
    private OrganizerDTO organizer;
    private Set<EventLocation> eventLocations = new HashSet<>();

    public EventDTO(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.desc = event.getDesc();
        this.img = event.getImg();
        this.organizer = new OrganizerDTO(event.getOrganizer()); // You can change this to OrganizerDTO if necessary
        // Convert Set<EventLocation> to Set<EventLocationDTO> if needed
        this.eventLocations = event.getEventLocations().stream()
                .collect(Collectors.toSet()); // Or use Event
    }
}
