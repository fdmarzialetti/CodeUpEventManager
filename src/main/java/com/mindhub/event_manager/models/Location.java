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
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID locationId;
    private String name;
    private int capacity;
    private String img;

    @OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocations = new HashSet<>();

    public void addEventLocation(EventLocation eventLocation){
        eventLocation.setLocation(this);
        this.eventLocations.add(eventLocation);
    }

}
