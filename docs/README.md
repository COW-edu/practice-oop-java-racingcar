1. 사용자로부터 자동차의 이름을 받기(쉼표로 구분)
- 이름은 공백 불가, 5이하 -> 그 외는 Exception
- 중복 이름 불가
- readLine() 사용, Scanner 사용 X
- 쉼표로 구분하기

2. 사용자로부터 몇번의 이동을 할 지 입력 받기
- 양의 정수로 받기 아니면 IllegalArgumentException
- 

3. 앞으로 전진하기
- 랜덤 숫자는 0~9 사의 값 무작위로 추출
- Randoms.pickNumber() >= 4 이상이면 distance++
- 차수별로 실행결과 출력하기

4. 우승자 출력하기
- 각 차량마다 distance 비교해서 distance가 가장 큰 자동차 고르기
- 여러명일경우 , 로 구분하여 출력하기

5. 예외처리
- 잘못된 입력 시 IllegealArgumentException으로 프로그램 종료시키기