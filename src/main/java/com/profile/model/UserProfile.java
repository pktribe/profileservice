package com.profile.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "userprofile")
public class UserProfile {
    
    @Id
    private String id; // profile id
    private String firstName;
    private String lastName;
    private long dob;
    private String billingAddress;
    private String shippingAddress;
    private String phone;
    private String email;

}
