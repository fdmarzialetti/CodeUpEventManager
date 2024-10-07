package com.mindhub.event_manager.models;

import com.mindhub.event_manager.dtos.appUser.AppUserCreateDTO;
import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import jakarta.persistence.*;
import lombok.Data;
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

    public AppUser(AppUserCreateDTO appUserCreateDTO){
        super(appUserCreateDTO.getName(), appUserCreateDTO.getLastname(), appUserCreateDTO.getEmail(), appUserCreateDTO.getPassword(), appUserCreateDTO.getCustomerRol());
        this.age = appUserCreateDTO.getAge();
        this.gender = appUserCreateDTO.getGender();
    }

    public AppUser(String name, String lastname, String email, String password, CustomerRol rol, byte age, CustomerGender gender) {
        super(name, lastname, email, password, rol);
        this.age = age;
        this.gender = gender;
    }

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
