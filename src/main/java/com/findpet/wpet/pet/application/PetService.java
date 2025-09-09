package com.findpet.wpet.pet.application;

import com.findpet.wpet.pet.domain.*;
import com.findpet.wpet.pet.dto.PetUpdateData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(PetCategoryType petCategoryType, Integer petAge, PetGenderType petGenderType, String petName) {
        Pet pet = new Pet(petCategoryType, petAge, petGenderType, petName);
        return petRepository.save(pet);
    }

    public List<Pet> selectPagePets(final int page, final int num){
        return petRepository.findAll(PageRequest.of(page,num))
                .stream()
                .collect(Collectors.toList());
    }

    public Pet findPetById(final Long petId) {
        return petRepository.findById(petId).
                orElseThrow(() -> new PetNotFoundException(petId));
    }

    @Transactional
    public Pet updatePet(final Long petId, final PetUpdateData petUpdateData) {
        Pet savedPet = findPetById(petId);
        savedPet.updatePetAge(petUpdateData.getUpdateAge());
        savedPet.updatePetGender(petUpdateData.getUpdateGender());
        savedPet.updatePetName(petUpdateData.getUpdateName());
        savedPet.updatePetCategory(petUpdateData.getUpdateCategory());
        return savedPet;
    }

    public void deletePet(final Long petId) {
        petRepository.deleteById(petId);
    }
}
