package com.mindhub.event_manager.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String comment;

    @ManyToOne
    @JoinColumn(name ="appUser_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name ="event_id")
    private Event event;

}
