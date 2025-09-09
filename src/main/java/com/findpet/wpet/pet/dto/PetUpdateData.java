package com.findpet.wpet.pet.dto;

import com.findpet.wpet.pet.domain.PetCategoryType;
import com.findpet.wpet.pet.domain.PetGenderType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PetUpdateData {

    private String updateName;
    private PetCategoryType updateCategory;
    private PetGenderType updateGender;
    private Integer updateAge;

    public PetUpdateData(final PetCategoryType updateCategory,
                         final Integer updateAge,
                         final PetGenderType updateGender,
                         final String updateName) {

        this.updateCategory = updateCategory;
        this.updateAge = updateAge;
        this.updateGender = updateGender;
        this.updateName = updateName;
    }
}
