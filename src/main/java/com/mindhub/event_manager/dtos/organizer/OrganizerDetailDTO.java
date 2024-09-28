package com.mindhub.event_manager.dtos.organizer;

import com.mindhub.event_manager.dtos.event.EventSummaryDTO;
import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Organizer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class OrganizerDetailDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private Set<EventSummaryDTO> events = new HashSet<>();

    public OrganizerDetailDTO(Organizer organizer){
        this.id = organizer.getId();
        this.name = organizer.getName();
        this.lastname = organizer.getLastname();
        this.email = organizer.getEmail();
        this.events = organizer.getEvents().stream().map(EventSummaryDTO::new).collect(Collectors.toSet());
    }

}
