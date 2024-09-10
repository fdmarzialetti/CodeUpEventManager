package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.CustomerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEventRepository extends JpaRepository<CustomerEvent,Long> {
}
