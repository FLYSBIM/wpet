package com.findpet.wpet.pet.dto;

import com.findpet.wpet.pet.domain.PetCategoryType;
import com.findpet.wpet.pet.domain.PetGenderType;

public class PetUpdateRequestDto implements PetRequestDto {

    private Long petId;
    private PetUpdateData petUpdateData;

    public PetUpdateRequestDto(final Long petId, final PetUpdateData petUpdateData) {
        this.petId = petId;
        this.petUpdateData = petUpdateData;
    }

    public Long getPetId() {
        return petId;
    }

    public PetUpdateData getPetUpdateData() {
        return petUpdateData;
    }

    @Override
    public PetCategoryType getCategoryType() {
        return petUpdateData.getUpdateCategory();
    }

    @Override
    public String getName() {
        return petUpdateData.getUpdateName();
    }

    @Override
    public PetGenderType getGenderType() {
        return petUpdateData.getUpdateGender();
    }

    @Override
    public Integer getAge() {
        return petUpdateData.getUpdateAge();
    }
}