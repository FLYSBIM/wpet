package com.findpet.wpet.pet.domain;

import com.findpet.wpet.common.domain.ModifiableEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "petId", callSuper = false)
@Table(name = "PET")
@Entity
public class Pet extends ModifiableEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Embedded
    private PetCategory petCategory;

    @Embedded
    private PetAge petAge;

    @Embedded
    private PetGender petGender;

    @Embedded
    private PetName petName;

    public Pet(final PetCategoryType petCategoryType,
               final Integer petAge,
               final PetGenderType petGenderType,
               final String petName) {
        this.petCategory = new PetCategory(petCategoryType);
        this.petAge = new PetAge(petAge);
        this.petGender = new PetGender(petGenderType);
        this.petName = new PetName(petName);
    }

    public Long getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName.getName();
    }

    public PetCategoryType getPetCategory() {
        return petCategory.getPetCategoryType();
    }

    public Integer getPetAge() {
        return petAge.getAge();
    }

    public PetGenderType getPetGender() {
        return petGender.getGenderType();
    }

    public void updatePetAge(final Integer age) {
        this.petAge = new PetAge(age);
    }

    public void updatePetGender(final PetGenderType GenderType) {
        this.petGender = new PetGender(GenderType);
    }

    public void updatePetName(final String name) {
        this.petName = new PetName(name);
    }

    public void updatePetCategory(final PetCategoryType petCategoryType) {
        this.petCategory = new PetCategory(petCategoryType);
    }
}