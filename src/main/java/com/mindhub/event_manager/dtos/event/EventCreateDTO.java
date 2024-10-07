package com.mindhub.event_manager.dtos.event;

import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Organizer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class EventCreateDTO {

    private UUID organizerId;
    private String name;
    private byte age_req;
    private String desc;
    private String img;

}
