package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.appUser.AppUserDTO;
import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/appUser")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDTO> getAppUser(@PathVariable UUID id) {
        return appUserRepository.findById(id)
                .map(appUser -> ResponseEntity.ok(new AppUserDTO(appUser))) // Return 200 OK with DTO
                .orElse(ResponseEntity.notFound().build());               // Return 404 if not found
    }
}
