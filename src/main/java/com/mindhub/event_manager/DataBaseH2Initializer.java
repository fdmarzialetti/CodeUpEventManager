package com.mindhub.event_manager;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataBaseH2Initializer {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(
            AppUserRepository appUserRepository,
            OrganizerRepository organizerRepository,
            CommentRepository commentRepository,
            AppUserEventLocationRepository appUserEventLocationRepository,
            EventRepository eventRepository,
            EventLocationRepository eventLocationRepository,
            LocationRepository locationRepository,
            ReactionRepository reactionRepository) {
        return args -> {
            // Initialize entities
            passwordEncoder.encode("1234");
            AppUser appUser1 = new AppUser("Luis","Gonzales","luis@gmail.com",passwordEncoder.encode("1234"), CustomerRol.USER, (byte) 20, CustomerGender.MALE);
            Organizer organizer1 = new Organizer("Ignacio","Perez","organizer@gmail.com",passwordEncoder.encode("1234"),CustomerRol.MANAGER);
            Organizer admin1 = new Organizer("Maria","Becerra","admin@gmail.com",passwordEncoder.encode("1234"),CustomerRol.ADMIN);
            Event event1 = new Event();
            Comment comment1 = new Comment();
            Comment comment2 = new Comment();
            Location location1 = new Location();
            EventLocation eventLocation1 = new EventLocation();
            AppUserEventLocation appUserEventLocation1 = new AppUserEventLocation();

            // Establish relationships
            appUser1.addCustomerEvent(appUserEventLocation1);
            appUser1.addComment(comment1);
            appUser1.addComment(comment2);

            organizer1.addEvent(event1);

            eventLocation1.addCustomerEvent(appUserEventLocation1);
            event1.addEventLocation(eventLocation1);
            event1.addComment(comment1);
            event1.addComment(comment2);
            location1.addEventLocation(eventLocation1);

            // Save related entities in the correct order
            organizerRepository.save(organizer1);
            appUserRepository.save(appUser1); // Save AppUser first
            organizerRepository.save(admin1);
            eventRepository.save(event1);
            locationRepository.save(location1);
            eventLocationRepository.save(eventLocation1);
            appUserEventLocationRepository.save(appUserEventLocation1);

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