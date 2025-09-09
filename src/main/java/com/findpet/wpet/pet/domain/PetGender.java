package com.findpet.wpet.pet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class PetGender {

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_gender", nullable = false)
    PetGenderType genderType;

    public PetGender(@NonNull PetGenderType genderType) {
        this.genderType = genderType;
    }
}
