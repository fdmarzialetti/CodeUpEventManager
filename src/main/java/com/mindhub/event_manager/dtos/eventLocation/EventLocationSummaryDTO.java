package com.mindhub.event_manager.dtos.eventLocation;

import com.mindhub.event_manager.dtos.location.LocationSummaryDTO;
import com.mindhub.event_manager.models.EventLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EventLocationSummaryDTO {

    private LocationSummaryDTO location;
    private LocalDateTime date;
    private int assistance;

    public EventLocationSummaryDTO(EventLocation eventLocation){
        this.date = eventLocation.getDate();
        this.location = new LocationSummaryDTO(eventLocation.getLocation());
        this.assistance = eventLocation.getAssistance();
    }
}
