<p>포켓몬 도감을 제작하는 개인 프로젝트입니다.</p>
<h1>배포환경</h1>
<div>
    <ul>
        <li>
          <strong>CLOUDTYPE</strong>
          <ul>
            <li>비용 문제로 인해 AWS EC2, RDS 초기설정만 적용 후 CLOUDTYPE에 배포 결정</li>
            <li>S3 데이터레이크만 이미지 저장용으로 사용.</li>
        </li>
    </ul>
</div>
<br/>
<h1>사용한 기술스택</h1>
<div>
    <ul>
        <li>
          <strong>JAVA 17</strong>
        </li>
        <li>
          <strong>Spring Boot</strong>
        </li>
        <li>
          <strong>Spring Security</strong>
          <ul>
            <li>Spring Security 로그인</li>
            <li>Spring Security 페이지 권환 활용</li>
          </ul>
        </li>
        <li>
          <strong>Spring Data JPA</strong>
        </li>
        <li>
          <strong>Querydsl</strong>
        </li>
        <li>
          <strong>Thymeleaf</strong>
        </li>
        <li>
          <strong>MariaDB</strong>
        </li>
    </ul>
</div>
<br/>
<br/>
<h1>구현 기능</h1>
<div>
    <ul>
        <li>
            <strong>계정 관련</strong>
            <ul>
                <li>로그인,로그아웃,회원가입</li>
                <li>비로그인 사용자 이용제한</li>
                <li>관리자 권한 계정만 포켓몬 등록, 수정 가능</li>
                <li>일반 유저 등록 수정 페이지 접근 불가</li>
            </ul>
        </li>
        <li>
            <strong>포켓몬 도감</strong>
            <ul>
                <li>도감 CRUD</li>
                <li>포켓몬 이름으로 검색 기능</li>
                <li>포켓몬 검색</li>
                <li>포켓몬 타입별 조회</li>
                <li>포켓몬 이미지 AWS S3 저장</li>
            </ul>
        </li>
    </ul>
</div>
<br/>
<br/>
<h1>이미지</h1>
<br/>
<div>
    <ul>
        <li>
            <strong>접속시 홈화면</strong>
            <ul>
                <li>로그인 페이지 버튼</li>
                <li>도감 페이지 버튼</li>
                <li>회원 전용 홈화면</li>
                <li>
                    <img width="1470" alt="스크린샷 2024-03-28 20 25 44" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/1d3c4529-084a-41be-84a6-31f4659ab54a">
                </li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 19 24 39" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/4c352aaa-f72c-47c2-a121-461086d8d949">
                </li>
            </ul>
        </li>
        <br/>
        <li>
            <strong>로그인</strong>
            <ul>
                <li>Spring Security 로그인 구현</li>
                <li>유효성 검사</li>
                <li>30분동안 활동 없을 경우 자동 로그아웃</li>
                <li>
                    <img width="1470" alt="스크린샷 2024-03-28 20 25 57" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/d2cd528d-6e02-4325-a123-adc09e269379">
                </li>
                <li>
                    <img width="1470" alt="스크린샷 2024-03-28 20 26 13" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/79e3c79f-6729-40e6-af6c-c834febe1de2">
                </li>
            </ul>
        </li>
        <br/>
        <li>
            <strong>회원가입</strong>
            <ul>
                <li>유효성 검사</li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 18 40 40" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/f2a7ab83-cf8c-4236-b178-775a8783c453">
                </li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 18 40 27" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/d2a973fa-8eb8-4142-967f-27055ac99967">
                </li>
            </ul>
        </li>
        <br/>
        <li>
            <strong>포켓몬 도감</strong>
            <ul>
                <li>포켓몬 이름 검색 구현</li>
                <li>포켓몬 도감 번호, 이름 클릭시 해당 포켓몬 상세페이지 이동</li>
                <li>타입 클릭시 해당 타입 포켓몬 목록 페이지 이동</li>
                <li>
                    <img width="1470" alt="스크린샷 2024-03-28 20 26 46" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/74dabc27-5936-4a0c-9884-cb35a52e0066">
                </li>
                <li>
                    <img width="1470" alt="스크린샷 2024-03-28 20 28 05" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/a7b7c8ce-8e7a-48ff-bffc-7b32f23a2c5b">
                </li>
            </ul>
        </li>
        <br/>
        <li>
            <strong>포켓몬 상세 페이지</strong>
            <ul>
                <li>관리자 한정 도감 수정</li>
                <li>해당 포켓몬 도감번호, 이름, 능력치, 타입 표시</li>
                <li>이미지 표시</li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 19 27 48" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/16721014-c1cf-4a4d-94d0-e9b8dd037eb0">
                </li>
            </ul>
        </li>
        <br/>
        <br/>
        <li>
            <strong>포켓몬 등록 폼</strong>
            <ul>
                <li>도감번호 능력치 이미지 등 기본 정보 등록</li>
                <li>Spring Security 권한 기능으로 관리자만 접속 가능</li>
                <li>유효성 검사 통과 못하면 입력했던 내용과 에러메세지를 다시 표시해줌</li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 19 29 33" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/dc954d87-dbe2-46af-a412-5f4db9b2f1b6">
                </li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 19 54 05" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/c7e0c260-8c41-4b5c-a910-23278ab52871">
                </li>
            </ul>
        </li>
        <br/>
        <br/>
        <li>
            <strong>포켓몬 수정 폼</strong>
            <ul>
                <li>기본정보 수정 가능</li>
                <li>Spring Security 권한 기능으로 관리자만 접속 가능</li>
                <li>오류 발생시 등록폼과 동일하게 입력했던 내용 에러메세지 표시</li>
                <li>
                    <img width="1104" alt="스크린샷 2024-03-30 20 01 58" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/a03c3abd-2cde-49ac-bdbc-af2993933360">
                </li>
                <li>
                  <img width="1104" alt="스크린샷 2024-03-30 20 02 10" src="https://github.com/GimLink/POKEDEX_DEPLOY/assets/88365662/9c901955-eb2a-47c3-a8dc-86547bc28c84">
                </li>
            </ul>
    </ul>
</div>
<br/>
<br/>
