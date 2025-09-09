package com.findpet.wpet.pet.dto;

import com.findpet.wpet.pet.domain.PetAge;
import com.findpet.wpet.pet.domain.PetCategoryType;
import com.findpet.wpet.pet.domain.PetGender;
import com.findpet.wpet.pet.domain.PetGenderType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PetCreateRequestDto implements PetRequestDto{

    private String name;
    private Integer age;
    private PetCategoryType categoryType;
    private PetGenderType genderType;

    public PetCreateRequestDto(final PetCategoryType categoryType,
                               final PetAge petAge,
                               final PetGenderType genderType,
                               final String name
                               ) {
        this.categoryType = categoryType;
        this.age = petAge.getAge();
        this.name = name;
        this.genderType = genderType;
    }

}
