package com.mindhub.event_manager.dtos.appUser;

import com.fasterxml.jackson.databind.ObjectReader;
import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Organizer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class OrganizerDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;

    public OrganizerDTO(Organizer organizer) {
        this.id = organizer.getId();
        this.name = organizer.getName();
        this.lastname = organizer.getLastname();
        this.email = organizer.getEmail();
    }
}
