package com.auth.controller;

import com.auth.entity.Preference;
import com.auth.model.request.PreferenceRequest;
import com.auth.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping
    public ResponseEntity<?> savePreference(
            @RequestBody PreferenceRequest request) {

        // Get logged-in user
        String userid = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        Preference preference = preferenceService
                .saveOrUpdate(userid, request);

        return ResponseEntity.ok(preference);
    }

    @GetMapping
    public ResponseEntity<?> getPreference() {

        // Get logged-in user
        String userid = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return ResponseEntity.ok(
                preferenceService.getPreference(userid)
        );
    }
}