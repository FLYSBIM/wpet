let currentPage = 0;
const petsPerPage = 10;

// DOM 요소 가져오기
const petListContainer = document.getElementById('pet-list-container');
const prevButton = document.getElementById('prev-button');
const nextButton = document.getElementById('next-button');
const pageNumberSpan = document.getElementById('page-number');

// 백엔드 API로부터 펫 목록을 가져오는 함수
async function fetchPets(page) {
    try {
        // API 호출 (fetch 사용)
        const response = await fetch(`/api/v1/pets?page=${page}&num=${petsPerPage}`);
        if (!response.ok) {
            throw new Error('데이터를 불러오는데 실패했습니다.');
        }
        const responseDto = await response.json(); // JSON 데이터를 객체로 변환
        const pets = responseDto.data.pets; // 실제 펫 목록 데이터

        // 화면을 새로 그리기
        renderPets(pets);
    } catch (error) {
        console.error(error);
        petListContainer.innerHTML = '<li>목록을 불러올 수 없습니다.</li>';
    }
}

// 받은 데이터로 화면에 목록을 그리는 함수
function renderPets(pets) {
    petListContainer.innerHTML = ''; // 기존 목록 초기화
    if (pets.length === 0) {
        petListContainer.innerHTML = '<li>등록된 반려동물이 없습니다.</li>';
        return;
    }

    pets.forEach(pet => {
        const petItem = document.createElement('li');
        petItem.textContent = `이름: ${pet.petName}, 나이: ${pet.petAge}, 종류: ${pet.petCategoryType}`;
        petListContainer.appendChild(petItem);
    });
}

// 버튼 이벤트 리스너 등록
nextButton.addEventListener('click', () => {
    currentPage++;
    pageNumberSpan.textContent = currentPage + 1;
    fetchPets(currentPage);
});

prevButton.addEventListener('click', () => {
    if (currentPage > 0) {
        currentPage--;
        pageNumberSpan.textContent = currentPage + 1;
        fetchPets(currentPage);
    }
});

// 첫 페이지 로드
fetchPets(currentPage);