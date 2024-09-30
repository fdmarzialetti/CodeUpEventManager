package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event,UUID> {

}
