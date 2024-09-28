package com.mindhub.event_manager.dtos.reaction;
import com.mindhub.event_manager.enums.ReactionType;
import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.models.Reaction;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionSummaryDTO {

    private ReactionType reactionType;

    public ReactionSummaryDTO(Reaction reaction){
        this.reactionType = reaction.getReactionType();
    }
}
