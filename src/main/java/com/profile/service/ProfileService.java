package com.profile.service;

import com.profile.model.UserProfile;
import com.profile.model.UserProfileData;

public interface ProfileService {
    
    public UserProfile newProfile(UserProfileData profile);
    public UserProfile updateProfile(UserProfileData profile, String id);
    public UserProfile getProfile(String id); 
    public boolean deleteProfile(String id);
}
