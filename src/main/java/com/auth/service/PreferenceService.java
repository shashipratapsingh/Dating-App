package com.auth.service;

import com.auth.entity.Preference;
import com.auth.model.request.PreferenceRequest;
import com.auth.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    public Preference saveOrUpdate(String userId, PreferenceRequest request) {

        Preference preference = preferenceRepository
                .findByUserId(userId)
                .orElse(new Preference());
        preference.setUserId(userId);
        preference.setPreferredGender(request.getPreferredGender());
        preference.setMinAge(request.getMinAge());
        preference.setMaxAge(request.getMaxAge());
        preference.setDistanceKm(request.getDistanceKm());
        return preferenceRepository.save(preference);
    }

    public Preference getPreference(String userId) {
        return preferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Preference not found"));
    }


}