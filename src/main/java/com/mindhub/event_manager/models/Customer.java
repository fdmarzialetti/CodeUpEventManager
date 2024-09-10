package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customer_id;
    private char name;
    private char lastname;
    private char email;
    private boolean activated;
    private char password;
    private short age;
    private CustomerGender gender;
    private CustomerRol rol;

    @OneToMany (mappedBy = "customer")
    private Set<Event> events = new HashSet<>();

    @OneToMany (mappedBy = "customer")
    private Set<Comment> comments = new HashSet<>();

    public Customer() {
    }

    public void addEvent(Event event){
        event.setCustomer(this);
        this.events.add(event);
    }

    public void addComment(Comment comment){
        comment.setCustomer(this);
        this.comments.add(comment);
    }

    public UUID getCustomer_id() {
        return customer_id;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getLastname() {
        return lastname;
    }

    public void setLastname(char lastname) {
        this.lastname = lastname;
    }

    public char getEmail() {
        return email;
    }

    public void setEmail(char email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public CustomerGender getGender() {
        return gender;
    }

    public void setGender(CustomerGender gender) {
        this.gender = gender;
    }

    public CustomerRol getRol() {
        return rol;
    }

    public void setRol(CustomerRol rol) {
        this.rol = rol;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
