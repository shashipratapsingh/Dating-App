package com.auth.controller;

import com.auth.entity.Profile;
import com.auth.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // ✅ Create / Update
    @PostMapping
    public Profile saveProfile(Authentication authentication, @RequestBody Profile request) {
        String email = authentication.getName();
        return profileService.saveProfile(email, request);
    }

    // ✅ Get Profile
    @GetMapping
    public Profile getProfile(Authentication authentication) {
        String email = authentication.getName();
        return profileService.getProfile(email);
    }
}