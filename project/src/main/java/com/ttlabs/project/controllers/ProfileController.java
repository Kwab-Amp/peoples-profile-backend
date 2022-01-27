package com.ttlabs.project.controllers;

import com.ttlabs.project.models.Profile;
import com.ttlabs.project.repositories.ProfileRepository;
import com.ttlabs.project.services.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/profiles")
public class ProfileController {
    private final ProfileServiceImpl profileService;

    @Autowired
    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @GetMapping(path = "/get-all-profiles/")
    public List<Profile> getAllProfiles(){
        return  profileService.getEmployeeProfiles();
    }

    @GetMapping(path = "/get-one-profile/{email}")
    public ResponseEntity<Profile> getOneProfile(@PathVariable String email) {
        var profile = profileService.findOne(email);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-profile/{id}")
    public void deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
    }

    @PostMapping(value = "/save-profile/")
    public void saveProfile(@RequestBody Profile profile){
        profileService.addProfile(profile);
    }

    @PostMapping(value = "/save-all-profiles")
    public void saveAllProfiles(@RequestBody List<Profile> profiles){
        profileService.addAllProfiles(profiles);
    }

    @PutMapping(value = "/update-profile/")
    public Profile updateProfile(){
        return  null;
    }

}
