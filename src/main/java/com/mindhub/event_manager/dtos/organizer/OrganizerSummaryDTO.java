package com.mindhub.event_manager.dtos.organizer;

import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.Organizer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@NoArgsConstructor
@Getter
public class OrganizerSummaryDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;

    public OrganizerSummaryDTO(Organizer organizer){
        this.id = organizer.getId();
        this.name = organizer.getName();
        this.lastname = organizer.getLastname();
        this.email = organizer.getEmail();
    }
}
