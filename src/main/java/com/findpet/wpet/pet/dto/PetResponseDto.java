package com.findpet.wpet.pet.dto;

import com.findpet.wpet.pet.domain.PetAge;
import com.findpet.wpet.pet.domain.PetCategoryType;
import com.findpet.wpet.pet.domain.PetGenderType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PetResponseDto {

    private Long petId;
    private String petName;
    private Integer petAge;
    private PetCategoryType petCategoryType;
    private PetGenderType petGenderType;

    public PetResponseDto(final Long id,
                          final PetCategoryType categoryType,
                          final PetAge petAge,
                          final PetGenderType genderType,
                          final String name) {

        this.petId = id;
        this.petCategoryType = categoryType;
        this.petAge = petAge.getAge();
        this.petGenderType = genderType;
        this.petName = name;
    }
}
