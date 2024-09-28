package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.CustomerGender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppUser extends Customer{

    private byte age;
    private CustomerGender gender;

    @OneToMany (mappedBy = "appUser")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "appUser")
    private Set<AppUserEventLocation> appUserEventLocations = new HashSet<>();

    @OneToMany(mappedBy = "appUser")
    private Set<Reaction> reactions = new HashSet<>();


    public void addReaction(Reaction reaction){
        reaction.setAppUser(this);
        reactions.add(reaction);
    }

    public void addComment(Comment comment){
        comment.setAppUser(this);
        this.comments.add(comment);
    }

    public void addCustomerEvent(AppUserEventLocation appUserEventLocation){
        appUserEventLocation.setAppUser(this);
        this.appUserEventLocations.add(appUserEventLocation);
    }
}
