package com.mindhub.event_manager.dtos.appUser;
import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.models.Comment;
import com.mindhub.event_manager.models.CustomerEventLocation;
import com.mindhub.event_manager.models.Reaction;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class AppUserDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private byte age;
    private CustomerGender gender;
    private Set<CommentDTO> comments = new HashSet<>();
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();
    private Set<Reaction> reactions = new HashSet<>();

    public AppUserDTO(AppUser appUser){
        this.id = appUser.getId();
        this.name = appUser.getName();
        this.lastname = appUser.getLastname();
        this.email = appUser.getEmail();
        this.age = appUser.getAge();
        this.gender = appUser.getGender();
        this.comments = appUser.getComments().stream().map(CommentDTO::new).collect(Collectors.toSet());
        this.customerEventLocations = new HashSet<>(appUser.getCustomerEventLocations()); // Assuming it's a simple mapping
        this.reactions = new HashSet<>(appUser.getReactions()); // Assuming Reaction is a simple entity or use ReactionDTO
    }
}
