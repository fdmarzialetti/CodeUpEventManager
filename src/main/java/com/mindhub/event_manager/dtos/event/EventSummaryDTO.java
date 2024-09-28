package com.mindhub.event_manager.dtos.event;

import com.mindhub.event_manager.dtos.comment.CommentSummaryDTO;
import com.mindhub.event_manager.dtos.eventLocation.EventLocationSummaryDTO;
import com.mindhub.event_manager.dtos.organizer.OrganizerSummaryDTO;
import com.mindhub.event_manager.dtos.reaction.ReactionSummaryDTO;
import com.mindhub.event_manager.models.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
@NoArgsConstructor
public class EventSummaryDTO {

    private String name;
    private byte age_req;
    private String desc;
    private String img;
    private OrganizerSummaryDTO organizer;

    public EventSummaryDTO(Event event){
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.desc = event.getDesc();
        this.img = event.getImg();
        this.organizer = new OrganizerSummaryDTO(event.getOrganizer());
    }
}
