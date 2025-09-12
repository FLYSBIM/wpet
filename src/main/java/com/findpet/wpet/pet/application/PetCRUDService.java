package com.findpet.wpet.pet.application;

import com.findpet.wpet.common.dto.ResponseData;
import com.findpet.wpet.common.dto.ResponseDto;
import com.findpet.wpet.common.dto.ResponseDtoMethod;
import com.findpet.wpet.common.dto.ResponseDtoStatusCode;
import com.findpet.wpet.pet.domain.Pet;
import com.findpet.wpet.pet.dto.PetRequestDto;
import com.findpet.wpet.pet.dto.PetResponseDto;
import com.findpet.wpet.pet.dto.PetUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetCRUDService {

    private static final String PETS_SERVLET_PATH = "/api/v1/pet";
    private static final String PAGE_QUERY_FORMAT = "?page=%d&num=%d";
    private static final String PET_CREATE_SUCCEED_RESPONSE_MESSAGE = "동물 등록 성공";
    private static final String PET_SELECT_PAGE_SUCCEED_RESPONSE_MESSAGE = "%d 페이지의 동물 목록 %d개";
    private static final String PET_SELECT_SUCCEED_RESPONSE_MESSAGE = "동물 조회 성공";
    private static final String PET_UPDATE_SUCCEED_RESPONSE_MESSAGE = "동물 업데이트 성공";
    private static final String PET_DELETE_SUCCEED_RESPONSE_MESSAGE = "동물 삭제 성공";

    private final PetService petService;

    @Autowired
    public PetCRUDService(final PetService petService) {
        this.petService = petService;
    }

    public ResponseDto createPet(PetRequestDto requestDto) {
        Pet savedPet = petService.createPet(requestDto.getCategoryType(), requestDto.getAge(), requestDto.getGenderType(), requestDto.getName());
        return ResponseDto.builder()
                .path(PETS_SERVLET_PATH)
                .method(ResponseDtoMethod.POST)
                .message(PET_CREATE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("pet", mapPetResponseDto(savedPet))
                        .build())
                .statusCode(ResponseDtoStatusCode.CREATED)
                .build();
    }

    public ResponseDto selectPet(final Long petId) {
        Pet findPet = petService.findPetById(petId);
        return ResponseDto.builder()
                .path(PETS_SERVLET_PATH)
                .method(ResponseDtoMethod.GET)
                .message(PET_SELECT_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("pet", mapPetResponseDto(findPet))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto selectPagePets(final int page, final int num) {
        List<Pet> pets = petService.selectPagePets(page, num);
        List<PetResponseDto> pagePets = pets.stream()
                .map(this::mapPetResponseDto)
                .collect(Collectors.toList());
        return ResponseDto.builder()
                .path(String.format(PETS_SERVLET_PATH + PAGE_QUERY_FORMAT, page, num))
                .method(ResponseDtoMethod.GET)
                .message(String.format(PET_SELECT_PAGE_SUCCEED_RESPONSE_MESSAGE, page, num))
                .data(ResponseData.builder()
                        .insert("pets", pagePets).build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto updatePet(final PetUpdateRequestDto requestDto) {
        Pet updatedPet = petService.updatePet(requestDto.getPetId(), requestDto.getPetUpdateData());
        return ResponseDto.builder()
                .path(PETS_SERVLET_PATH)
                .method(ResponseDtoMethod.PUT)
                .message(PET_UPDATE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("pet", mapPetResponseDto(updatedPet))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto deletePet(final Long petId) {
        Pet findPet = petService.findPetById(petId);
        petService.deletePet(petId);
        return ResponseDto.builder()
                .path(PETS_SERVLET_PATH)
                .method(ResponseDtoMethod.DELETE)
                .message(PET_DELETE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("deletedPet", mapPetResponseDto(findPet))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    private PetResponseDto mapPetResponseDto(final Pet pet) {
        return new PetResponseDto(pet.getPetId(), pet.getPetCategory(), pet.getPetAge(), pet.getPetGender(), pet.getPetName());
    }
}