package com.mindhub.event_manager.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID location_id;
    private char name;
    private int capacity;
    private String img;

    @OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocations = new HashSet<>();

    public Location() {
    }

    public void addEventLocation(EventLocation eventLocation){
        eventLocation.setLocation(this);
        this.eventLocations.add(eventLocation);
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(Set<EventLocation> eventLocation) {
        this.eventLocations = eventLocation;
    }
}
