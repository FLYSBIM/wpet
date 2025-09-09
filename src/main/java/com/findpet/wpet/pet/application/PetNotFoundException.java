package com.findpet.wpet.pet.application;

import lombok.Getter;

@Getter
public class PetNotFoundException extends RuntimeException {

  private static final String NOT_FOUND_PET_EXCEPTION_MESSAGE = "해당 ID에 해당하는 동물이 없습니다.";

  private Long petId;

  PetNotFoundException(Long petId) {
    super(NOT_FOUND_PET_EXCEPTION_MESSAGE);
    this.petId = petId;
  }
}
