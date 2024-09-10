package com.mindhub.event_manager.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID event_id;
    private char name;
    private short age_req;
    private String desc;
    private String img;

    @ManyToOne
    @JoinColumn(name ="organizer_id")
    private Customer customer;

    @OneToMany(mappedBy = "event")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventLocation> eventLocations = new HashSet<>();


    public Event() {
    }


    public void addComment(Comment comment){
        comment.setEvent(this);
        this.comments.add(comment);
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        this.eventLocations.add(eventLocation);
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(Set<EventLocation> eventLocation) {
        this.eventLocations = eventLocation;
    }

    public UUID getEvent_id() {
        return event_id;
    }


    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public short getAge_req() {
        return age_req;
    }

    public void setAge_req(short age_req) {
        this.age_req = age_req;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
