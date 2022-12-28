package com.profile.service;

import com.profile.model.UserProfile;
import com.profile.model.UserProfileData;
import com.profile.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.profile.util.ResourceNotFoundException;
import com.profile.util.Util;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository repo;

    private String userProfile = "UserProfile";

    @Override
    public UserProfile newProfile(UserProfileData profile) {
        String id = Util.generateRandomUUID();
        UserProfile uProfile = new UserProfile();
        uProfile.setId(id);
        uProfile.setFirstName(profile.getFirstName());
        uProfile.setLastName(profile.getLastName());
        uProfile.setDob(profile.getDob());
        uProfile.setEmail(profile.getEmail());
        uProfile.setPhone(profile.getPhone());
        uProfile.setBillingAddress(profile.getBillingAddress());
        uProfile.setShippingAddress(profile.getShippingAddress());
        return repo.save(uProfile);
    }

    @Override
    public UserProfile updateProfile(UserProfileData profile, String id) {
        UserProfile up = repo.findById(id).orElseThrow(()->new ResourceNotFoundException(userProfile, "id", id));

		up.setBillingAddress(profile.getBillingAddress());
        up.setShippingAddress(profile.getShippingAddress());

       return repo.save(up);
    }

    @Override
    public UserProfile getProfile(String id) {
        return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(userProfile, "id", id));
    }

    @Override
    public boolean deleteProfile(String id) {
        UserProfile up = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(userProfile, "id", id));

		repo.delete(up);
        return true;
    }
}
