package com.findpet.wpet.pet.dto;

import com.findpet.wpet.pet.domain.PetCategoryType;
import com.findpet.wpet.pet.domain.PetGenderType;

public interface PetRequestDto {

    public PetCategoryType getCategoryType();
    public String getName();
    public PetGenderType getGenderType();
    public Integer getAge();
}
