## 도메인
### 모델
- [X] RacingCar 클래스
  - [X] name 길이 검증 메서드
  - [X] name 존재 검증 메서드
  - [ ] name 공백 검증 메서드
  - [X] position move 메서드
- [X] RacingCar을 리스트로 한 RacingCars 클래스
  - [X] 이름 중복 검증 메서드
  - [X] 이름 목록 Empty 검증 메서드
  - [X] 레이스 참가 레이싱카 생성 팩토리 메서드 //이펙티브 자바
- [X] 게임을 담당할 Race 클래스 생성
  - [X] 게임 시작 메서드
  - [X] position 비교 메서드
- [X] 각 라운드 위해 Round 클래스 생성
- [X] 레이스 승리 결과 WinningResult 클래스 생성
  - [X] position 비교 메서드 - Race에서 가져오기


## 컨트롤러
- [ ] 컨트롤러(컨트롤러 인터페이스화)
  - [ ] InitialController 생성
  - [ ] RaceController 생성
  - [ ] ResultController 생성
  - [ ] Config로 상황에 맞는 Contoller 호출되게 설계

## View
- [ ] view(인터페이스로 나누기 outView 재사용 위해)
  - [ ] 출력 되는 것들은 전부 outView 로
  - [ ] 입력받는 것들은 전부 inputView 로