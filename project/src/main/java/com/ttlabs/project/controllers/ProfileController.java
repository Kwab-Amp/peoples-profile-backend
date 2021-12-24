package com.ttlabs.project.controllers;

import com.ttlabs.project.models.Profile;
import com.ttlabs.project.repositories.ProfileRepository;
import com.ttlabs.project.services.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProfileController {
    private final ProfileServiceImpl profileService;

    @Autowired
    public ProfileController(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "get-all-profiles/",method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        return  profileService.getEmployeeProfiles();
    }

    @RequestMapping(path = "delete-profile/{id}",method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
    }

    @RequestMapping(value = "save-profile/",method = RequestMethod.POST)
    public void saveProfile(@RequestBody Profile profile){
        profileService.addProfile(profile);
    }

    @RequestMapping(value = "save-all-profiles",method = RequestMethod.POST)
    public void saveAllProfiles(@RequestBody List<Profile> profiles){
        profileService.addAllProfiles(profiles);
    }

    @RequestMapping(value = "update-profile/",method = RequestMethod.PUT)
    public Profile updateProfile(){
        return  null;
    }

}
