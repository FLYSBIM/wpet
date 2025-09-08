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
public class PetCategory {

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_category_type", nullable = false, updatable = false)
    private PetCategoryType petCategoryType;

    public PetCategory(@NonNull final PetCategoryType petCategoryType) {
        this.petCategoryType = petCategoryType;
    }
}
