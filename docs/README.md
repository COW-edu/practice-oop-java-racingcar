# 구현할 기능 목록

## Model

### Domain
- RacingCar (하나의 레이싱 카)
  - 차 이름 출력을 위한 getter
  - 차 위치 이동 메서드
- AllRacingCars (모든 레이싱 카들)
  - 최종 우승자 반환 메서드
- FullGame (전체 경기)
- Game (단일 경기)
- GameRecords (경기 기록)
- FinalWinners (최종 우승자)
  - 최종 우승자 계산 메서드
  - 최종 우승자 출력을 위한 getter

### Service
- RacingCarService (객체 생성과 메서드 호출 담당, 없애고 싶다.)

1. 컨트롤러로부터 전달 받은 자동차 이름으로 RacingCar 객체 생성 
2. RacingCar 객체들로 AllRacingCars 객체 생성
2. AllRacingCars 객체와 컨트롤러로부터 전달 받은 시도 횟수로 FullGame 객체 생성
3. FullGame 객체 내에서 GameResult 생성
4. AllGameResults의 각 GameResult가 반환한 우승자들을 모아 FinalWinners 객체 생성
    - 각 GameResult 객체 내에서 하이픈 개수 비교
6. GameResult에서 단일 경기 우승자 Winners 객체로 반환 
7. 반환한 Winners 객체들을 WinnerCounts로 생성
8. WinnerCounts에서 최종 우승자 FinalWinners로 생성 및 반환


## View

### Input
1. 경주할 자동차 이름 입력 받기
2. 시도할 횟수 입력 받기

### Output
1. 각 차수별 실행 결과 출력 하기
2. 단독 우승자 안내 문구 출력 하기 or 공동 우승자 안내 문구 출력 하기

## Controller
1. 뷰에서 입력 받은 경주할 자동차 이름 파싱 및 검증
2. 서비스 객체에 자동차 이름 전달
3. 뷰에서 입력 받은 시도 횟수 파싱 및 검증
4. 서비스 객체에 시도 횟수 전달
5. 서비스 객체로부터 AllGameResults 객체 받아 와서 변환
6. 변환한 AllGameResults 뷰에게 전달
7. 서비스 객체로부터 FinalWinners 받아 와서 변환
8. 변환한 FinalWinners 뷰에게 전달
