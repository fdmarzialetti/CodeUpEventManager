package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.AppUserEventLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserEventLocationRepository extends JpaRepository<AppUserEventLocation, UUID> {
}
