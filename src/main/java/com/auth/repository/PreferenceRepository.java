package com.auth.repository;

import com.auth.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {

    Optional<Preference> findByUserId(String userId);

    boolean existsByUserId(String userId);

    void deleteByUserId(String userId);
}