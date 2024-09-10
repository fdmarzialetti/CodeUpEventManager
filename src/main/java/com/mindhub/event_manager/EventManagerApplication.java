package com.mindhub.event_manager;

import com.mindhub.event_manager.models.Comment;
import com.mindhub.event_manager.models.Customer;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.repositories.CommentRepositorie;
import com.mindhub.event_manager.repositories.CustomerRepositorie;
import com.mindhub.event_manager.repositories.EventRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CustomerRepositorie customerRepositorie, EventRepositorie eventRepositorie, CommentRepositorie commentRepositorie){
		return args -> {
			Customer customer1 = new Customer();
			Event event1 = new Event();
			Comment comment1 = new Comment();
			customer1.addComment(comment1);
			customer1.addEvent(event1);
			event1.addComment(comment1);
			customerRepositorie.save(customer1);
			eventRepositorie.save(event1);
			commentRepositorie.save(comment1);
		};
	}
}
