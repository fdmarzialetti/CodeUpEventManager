package com.mindhub.event_manager.models;
import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID customerId;
    private String name;
    private String lastname;
    private String email;
    private boolean activated = true;
    private String password;
    private byte age;
    private CustomerGender gender;
    private CustomerRol rol;

    @OneToMany (mappedBy = "customer")
    private Set<Event> events = new HashSet<>();

    @OneToMany (mappedBy = "customer")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();

    @OneToMany(mappedBy="customer")
    private Set<Reaction> reactions = new HashSet<>();


    public void addReaction(Reaction reaction){
        reaction.setCustomer(this);
        reactions.add(reaction);
    }

    public void addEvent(Event event){
        event.setCustomer(this);
        this.events.add(event);
    }

    public void addComment(Comment comment){
        comment.setCustomer(this);
        this.comments.add(comment);
    }

    public void addCustomerEvent(CustomerEventLocation customerEventLocation){
        customerEventLocation.setCustomer(this);
        this.customerEventLocations.add(customerEventLocation);
    }

}
