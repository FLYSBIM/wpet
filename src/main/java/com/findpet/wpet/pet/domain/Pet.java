package com.findpet.wpet.pet.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "petno", callSuper = false)
@Table(name = "PET")
@Entity
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_no")
    private Long petno;

    @Embedded
    private PetName petName;

    @Embedded
    private PetAge petAge;

    @Embedded
    private PetGender petGender;

    @Embedded
    private PetCategory petCategory;
}
