package com.mindhub.event_manager.dtos.comment;

import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.models.Comment;
import com.mindhub.event_manager.models.Event;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.binder.internal.CommentsBinder;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class CommentSummaryDTO {
    private UUID id;
    private String comment;

    public CommentSummaryDTO(Comment comment){
        this.id=comment.getId();
        this.comment = comment.getComment();
    }
}
