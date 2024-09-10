package com.mindhub.event_manager.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID comment_id;
    private char comment;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="event_id")
    private Event event;

    public Comment() {
    }

    public UUID getComment_id() {
        return comment_id;
    }

    public char getComment() {
        return comment;
    }

    public void setComment(char comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
