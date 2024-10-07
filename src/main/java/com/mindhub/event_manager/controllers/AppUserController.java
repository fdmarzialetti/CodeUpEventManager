package com.mindhub.event_manager.controllers;
import com.mindhub.event_manager.dtos.appUser.AppUserCreateDTO;
import com.mindhub.event_manager.dtos.appUser.AppUserDTO;
import com.mindhub.event_manager.models.AppUser;
import com.mindhub.event_manager.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appUsers")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<AppUserDTO>> getListDTO(){
        List<AppUserDTO> list=appUserRepository.findAll().stream().filter(a->a.isActivated()).map(AppUserDTO::new).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppUserDTO> getAppUserDTO(@PathVariable UUID id){
        return  new ResponseEntity<>(new AppUserDTO(appUserRepository.findById(id).orElse(null)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppUserDTO> createAppUser(@RequestBody AppUserCreateDTO appUserCreateDTO) {
        appUserCreateDTO.encodePassword(passwordEncoder);
        AppUser appUser = new AppUser(appUserCreateDTO);
        AppUser savedUser = appUserRepository.save(appUser);
        return new ResponseEntity<>(new AppUserDTO(savedUser), HttpStatus.CREATED);
    }

}