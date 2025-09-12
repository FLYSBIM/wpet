const API_BASE_URL = 'http://localhost:8080/api/v1/pets';

const addPetForm = document.getElementById('add-pet-form');
const petNameInput = document.getElementById('petName');
const petAgeInput = document.getElementById('petAge');
const petCategoryInput = document.getElementById('petCategory');
const petGenderInput = document.getElementById('petGender');

// 폼 제출(submit) 이벤트 리스너 등록
addPetForm.addEventListener('submit', addPet);

async function addPet(event) {
    // 폼의 기본 제출 동작(페이지 새로고침)을 방지합니다.
    event.preventDefault();

    const petData = {
        name: petNameInput.value,
        age: parseInt(petAgeInput.value, 10),
        categoryType: petCategoryInput.value, // 수정됨
        genderType: petGenderInput.value      // 수정됨
    };

    if (!petData.name || !petData.age || !petData.categoryType || !petData.genderType) {
        alert("모든 필수 정보를 입력해주세요.");
        return;
    }

    try {
        // fetch API를 사용하여 서버에 POST 요청을 보냅니다.
        const response = await fetch(API_BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(petData),
        });

        // 서버 응답이 성공적이지 않으면 에러를 발생시킵니다.
        if (!response.ok) {
            throw new Error(`서버 응답 오류: ${response.status}`);
        }

        // PetResponseDto 형식의 데이터를 받습니다.
        const newPet = await response.json();
        console.log('성공적으로 등록된 반려동물:', newPet);

        alert('새로운 반려동물이 성공적으로 등록되었습니다.');

        // 등록 성공 후 폼의 입력 필드를 초기화합니다.
        addPetForm.reset();

    } catch (error) {
        console.error('반려동물 등록 중 오류 발생:', error);
        alert('등록 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
    }
}