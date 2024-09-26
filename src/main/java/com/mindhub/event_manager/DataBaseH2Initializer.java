package com.mindhub.event_manager;

import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseH2Initializer {
    @Bean
    public CommandLineRunner initData(
            AppUserRepository appUserRepository,
            OrganizerRepository organizerRepository,
            CommentRepository commentRepository,
            CustomerEventLocationRepository customerEventLocationRepository,
            EventRepository eventRepository,
            EventLocationRepository eventLocationRepository,
            LocationRepository locationRepository,
            ReactionRepository reactionRepository) {
        return args -> {
            // Initialize entities
            AppUser appUser1 = new AppUser();
            Organizer organizer1 = new Organizer();
            Event event1 = new Event();
            Comment comment1 = new Comment();
            Comment comment2 = new Comment();
            Location location1 = new Location();
            EventLocation eventLocation1 = new EventLocation();
            CustomerEventLocation customerEventLocation1 = new CustomerEventLocation();

            // Establish relationships
            appUser1.addCustomerEvent(customerEventLocation1);
            appUser1.addComment(comment1);
            appUser1.addComment(comment2);

            organizer1.addEvent(event1);

            eventLocation1.addCustomerEvent(customerEventLocation1);
            event1.addEventLocation(eventLocation1);
            event1.addComment(comment1);
            event1.addComment(comment2);
            location1.addEventLocation(eventLocation1);

            // Save related entities in the correct order
            organizerRepository.save(organizer1);
            appUserRepository.save(appUser1); // Save AppUser first
            eventRepository.save(event1);
            locationRepository.save(location1);
            eventLocationRepository.save(eventLocation1);
            customerEventLocationRepository.save(customerEventLocation1);

            commentRepository.save(comment1); // Save comments after AppUser
            commentRepository.save(comment2);

            // Create and save reactions
            Reaction reaction1 = new Reaction(event1, appUser1);
            appUser1.addReaction(reaction1);
            event1.addReaction(reaction1);

            Reaction reaction2 = new Reaction(event1, appUser1);

            reactionRepository.save(reaction1);
            reactionRepository.save(reaction2);
        };
    }
}