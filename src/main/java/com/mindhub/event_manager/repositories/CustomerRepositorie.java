package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositorie extends JpaRepository<Customer,Long> {
}
