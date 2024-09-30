package com.mindhub.event_manager.controllers;
import com.mindhub.event_manager.dtos.appUser.AppUserDTO;
import com.mindhub.event_manager.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appUser")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping
    public ResponseEntity<List<AppUserDTO>> getListDTO(){
        List<AppUserDTO> list=appUserRepository.findAll().stream().filter(a->a.isActivated()).map(AppUserDTO::new).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppUserDTO> getAppUserDTO(@PathVariable UUID id){
        return  new ResponseEntity<>(new AppUserDTO(appUserRepository.findById(id).orElse(null)),HttpStatus.OK);
    }
}