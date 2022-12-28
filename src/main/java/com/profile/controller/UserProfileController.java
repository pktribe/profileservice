package com.profile.controller;

import com.profile.model.UserProfile;
import com.profile.model.UserProfileData;
import com.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/profile/")
public class UserProfileController {
    
  @Autowired
  private ProfileService service;

  @GetMapping("{id}")
  public UserProfile get(@PathVariable String id) {
    log.info("ss");
    return service.getProfile(id);
  }

  @PostMapping
  public UserProfile newProfile(@RequestBody UserProfileData profile){

    return service.newProfile(profile);
  }

  @PutMapping("{id}")
  public UserProfile editProfile(@RequestBody UserProfileData profile, @PathVariable String id){
    return service.updateProfile(profile, id);
  }

  @DeleteMapping("{id}")
  public boolean deleteProfile(@PathVariable String id){
    return service.deleteProfile(id); 
  }
}
