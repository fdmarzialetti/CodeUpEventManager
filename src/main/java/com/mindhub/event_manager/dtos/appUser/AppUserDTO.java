package com.mindhub.event_manager.dtos.appUser;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.models.AppUser;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AppUserDTO {
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private byte age;
    private CustomerGender gender;

    public AppUserDTO(AppUser appUser){
        this.id=appUser.getId();
        this.email= appUser.getEmail();
        this.name= appUser.getName();
        this.lastname= appUser.getName();
        this.age=appUser.getAge();
        this.gender=appUser.getGender();
    }
}
