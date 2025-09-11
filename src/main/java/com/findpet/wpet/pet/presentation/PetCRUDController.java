package com.findpet.wpet.pet.presentation;

import com.findpet.wpet.pet.application.PetCRUDService;
import com.findpet.wpet.pet.dto.PetCreateRequestDto;
import com.findpet.wpet.pet.dto.PetUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pets")
public class PetCRUDController {

    PetCRUDService petCRUDService;

    @Autowired
    public PetCRUDController(PetCRUDService petCRUDService) {
        this.petCRUDService = petCRUDService;
    }

    @PostMapping("")
    public ResponseEntity createPet(@RequestBody final PetCreateRequestDto petCreateRequestDto) {
        return ResponseEntity.ok(petCRUDService.createPet(petCreateRequestDto));
    }

    @GetMapping("/{petId}")
    public ResponseEntity getPet(@PathVariable final Long petId) {
        return ResponseEntity.ok(petCRUDService.selectPet(petId));
    }

    @PutMapping("")
    public ResponseEntity updatePet(@RequestBody final PetUpdateRequestDto petUpdateRequestDto) {
        return ResponseEntity.ok(petCRUDService.updatePet(petUpdateRequestDto));
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity deletePet(@PathVariable final Long petId) {
        return ResponseEntity.ok(petCRUDService.deletePet(petId));
    }
}
