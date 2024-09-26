package com.mindhub.event_manager.dtos.appUser;

import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.models.Comment;
import com.mindhub.event_manager.models.Event;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@NoArgsConstructor
public class CommentDTO {

    private UUID id;
    private String comment;
    private EventDTO event;

    public CommentDTO(Comment comment){
        this.id = comment.getId();
        this.comment = getComment();
        this.event = new EventDTO(comment.getEvent());
    }
}
