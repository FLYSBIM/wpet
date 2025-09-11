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

    @Column(name = "pet_name")
    private String name;

    public PetName(final String petName) {
        this.name = petName;
    }
}
