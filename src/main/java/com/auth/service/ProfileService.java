package com.auth.service;

import com.auth.entity.Profile;
import com.auth.entity.Users;
import com.auth.repository.ProfileRepository;

import com.auth.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UsersRepository userRepository;

    // ✅ Create / Update Profile
    public Profile saveProfile(String email, Profile request) {

        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Profile> existingProfile = profileRepository.findByUser(user);

        Profile profile = existingProfile.orElse(new Profile());

        profile.setUser(user);
        profile.setName(request.getName());
        profile.setAge(request.getAge());
        profile.setGender(request.getGender());
        profile.setBio(request.getBio());
        profile.setPhotos(request.getPhotos());

        return profileRepository.save(profile);
    }

    // ✅ Get Profile
    public Profile getProfile(String email) {

        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return profileRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}