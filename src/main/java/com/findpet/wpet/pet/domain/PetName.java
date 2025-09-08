package com.findpet.wpet.pet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class PetName {

    @Column(name = "pet_name", updatable = true)
    private String name;

    public PetName(final String petName) {
        validatePetName(petName);
        this.name = petName;
    }

    private void validatePetName(final String petName) {
        if(petName == null || petName.isBlank()) {
            throw new IllegalArgumentException("Pet name cannot be null or empty");
        }
        if(petName.length() > 100){
            throw new IllegalArgumentException("Pet name is too long");
        }
    }
}
