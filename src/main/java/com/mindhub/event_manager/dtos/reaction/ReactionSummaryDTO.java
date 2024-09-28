package com.mindhub.event_manager.dtos.reaction;
import com.mindhub.event_manager.enums.ReactionType;
import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.models.Reaction;
import com.mindhub.event_manager.models.ReactionId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReactionSummaryDTO {
    private ReactionId id;
    private ReactionType reactionType;

    public ReactionSummaryDTO(Reaction reaction){
        this.id = reaction.getId();
        this.reactionType = reaction.getReactionType();
    }
}
