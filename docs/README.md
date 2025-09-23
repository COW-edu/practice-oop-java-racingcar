
1. Car: 자동차의 생성, 전진/정지를 결정, 결과를 저장.
-> 변수: moveCount = 전진 횟수, carName = 차량 이름(String)
-> 메소드
* 생성자/init(생성자가 쓰이지 않을 케이스를 염두해두고 만듦. 내용은 생성자와 동일.): 이름을 파라미터로 받아서 저장, moveCount 초기화.
* moveForward: moveCount ++
* isCarMove: 랜덤 숫자의 크기에 따라 차가 전진/정지 결정하는 함수.
* update: isCarMove에 따라 moveForward를 호출/ 호출X를 결정.

2. InputOutput: 입력 값 받고, 결과 값 출력
-> 변수: carCount = 차량 개수, carNames = 차량 이름들을 저장하는 String 배열
-> 메소드:
* readCarNames: 사용자의 입력 -> 이름들 분리하여 저장 + 차량 개수 저장.
* readDriveCount: 사용자의 입력 -> round 개수 저장.
* printRoundResult: 각 라운드의 결과 값을 출력. 라운드 종료 시점의 car의 moveCount를 출력함.
* printWinner: 모든 라운드 종료 후, winner를 출력

3. Application: 실제 프로그램의 플로우가 진행될 곳.
-> 변수: inputOutput = InputOutput class를 멤버로 가지고 있음. cars = Car class를 배열로 가지고 있음.
        driveCount = round 개수, carCount = 차량 개수
-> FLOW: 차량 이름 입력 -> round 개수 입력 -> 차량 개수만큼 차량 생성 -> 첫 번째 round 실행()
            -> 결과 값 출력 -> (round 개수만큼 반복) -> 우승자 출력