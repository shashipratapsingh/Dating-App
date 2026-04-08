package com.auth.model.request;

import com.auth.enums.Gender;
import lombok.Data;

@Data
public class PreferenceRequest {

    private Gender preferredGender;
    private Integer minAge;
    private Integer maxAge;
    private Integer distanceKm;

}