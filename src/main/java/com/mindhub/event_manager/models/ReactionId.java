package com.mindhub.event_manager.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReactionId implements Serializable{
    @Column(name = "event_id")
    private UUID event;
    @Column(name = "user_id")
    private UUID user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReactionId that = (ReactionId) o;

        if (!event.equals(that.event)) return false;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = event.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}

