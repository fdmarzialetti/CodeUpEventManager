package com.mindhub.event_manager.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID commentId;

    private String comment;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="event_id")
    private Event event;

}
