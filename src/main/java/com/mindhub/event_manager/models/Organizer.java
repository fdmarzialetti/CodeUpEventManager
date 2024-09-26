package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Organizer extends Customer{

    @OneToMany (mappedBy = "organizer")
    private Set<Event> events = new HashSet<>();

    public void addEvent(Event event){
        event.setOrganizer(this);
        this.events.add(event);
    }
}
