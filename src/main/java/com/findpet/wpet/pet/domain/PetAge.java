package com.findpet.wpet.pet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class PetAge {

    @Column(name = "pet_age")
    private Integer age;

    public PetAge(final Integer petAge) {
        validatePetAge(petAge);
        this.age = petAge;
    }

    private void validatePetAge(final Integer petAge) {
        if (petAge == null) {
            throw new IllegalArgumentException("Pet Age cannot be null");
        }
        if (petAge < 0) {
            throw new IllegalArgumentException("Pet Age must be a positive integer");
        }
    }
}