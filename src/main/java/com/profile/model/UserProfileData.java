package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserProfileData {
    
    private String firstName;
    private String lastName;
    private long dob;
    private String billingAddress;
    private String shippingAddress;
    private String phone;
    private String email;
}
