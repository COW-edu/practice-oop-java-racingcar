# 이펙티브 자바 원칙을 적용한 자동차 경주 게임 설계

## 목차
1. [프로젝트 소개](#1-프로젝트-소개)
2. [적용한 이펙티브 자바 원칙](#2-적용한-이펙티브-자바-원칙)
3. [객체지향 설계 원칙 적용](#3-객체지향-설계-원칙-적용)
4. [설계 개선 과정](#4-설계-개선-과정)
5. [테스트 용이성](#5-테스트-용이성)
6. [결론 및 추가 개선 가능성](#6-결론-및-추가-개선-가능성)

## 1. 프로젝트 소개

### 자동차 경주 게임 요구사항
- 0~9 사이의 무작위 값이 4 이상일 경우 자동차가 전진
- 자동차별로 이름 부여 가능 (최대 5자)
- 사용자 입력으로 자동차 이름 및 시도 횟수 결정
- 경주 완료 후 가장 멀리 이동한 자동차를 우승자로 선정

### 프로젝트 구조
```
racingcar
├── domain           # 핵심 도메인 객체
│   ├── car          # 자동차 관련 (Car, CarName, Cars)
│   └── strategy     # 전략 관련 (MovementStrategy, RandomMovement)
├── dto              # 데이터 전송 객체 (RoundResultDto)
├── view             # 뷰 관련 (View, ConsoleView)
└── constants        # 상수 관련 (ErrorMessage)
```

## 2. 적용한 이펙티브 자바 원칙

### 아이템 1: 생성자 대신 정적 팩터리 메서드를 고려하라

**CarName 클래스에 적용:**
```java
public class CarName {
    private final String value;
    private static final int NAME_LIMIT_LENGTH = 5;
    
    private CarName(String value) {  // private 생성자
        this.value = value;
    }
    
    public static CarName from(String name) {  // 정적 팩터리 메서드
        validateName(name);
        return new CarName(name);
    }
    
    // ...
}
```

**Car 클래스에 적용:**
```java
public class Car {
    // ...
    
    public static Car create(CarName name, int position) {
        return new Car(name, position);
    }
    
    // ...
}
```

**적용 이유:**
- 메서드 이름을 통해 객체 생성 의도를 명확히 전달
- 호출할 때마다 새 객체 생성이 필요 없음 (캐싱 가능)
- 하위 타입 객체 반환 가능성 제공
- 정적 팩터리 메서드 파라미터에 따라 다양한 생성 방식 지원

**얻은 효과:**
- 코드 가독성과 의도 표현력 향상
- 객체 생성 로직 캡슐화
- 확장 가능성 확보

### 아이템 17: 변경 가능성을 최소화하라

**CarName을 불변 클래스로 설계:**
```java
public final class CarName {  // 상속 방지
    private final String value;  // 불변 필드
    
    // ...
    
    @Override
    public String toString() {
        return value;
    }
}
```

**Car에서 불변성 활용:**
```java
public Car move(MovementStrategy strategy) {
    if (strategy.shouldMove()) {
        return new Car(this.name, this.position + 1);  // 새 객체 반환
    }
    return this;
}
```

**적용 이유:**
- 불변 객체는 단순하고 스레드 안전함
- 상태 변경 시 새로운 객체를 생성하여 부수효과 방지
- 불변 객체는 공유하기 쉬움

**얻은 효과:**
- 예측 가능한 동작으로 버그 감소
- 동시성 문제 사전 방지
- 방어적 복사본이 필요 없어 성능 향상

### 아이템 5: 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

**RaceManager 클래스에 적용:**
```java
public class RaceManager {
    private final View view;
    private final MovementStrategy movementStrategy;
    private Cars cars;

    public RaceManager(View view, MovementStrategy movementStrategy) {
        this.view = view;
        this.movementStrategy = movementStrategy;
    }
    
    // ...
}
```

**Application 클래스에서 의존성 주입:**
```java
public class Application {
    public static void main(String[] args) {
        try {
            View view = new ConsoleView();
            MovementStrategy strategy = new RandomMovement();
            RaceManager raceManager = new RaceManager(view, strategy);
            raceManager.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

**적용 이유:**
- 테스트 용이성 확보 (테스트에서 다른 전략 주입 가능)
- 유연성 향상 (다양한 구현체로 쉽게 교체 가능)
- 싱글턴이나 정적 유틸리티 클래스의 단점 회피

**얻은 효과:**
- 낮은 결합도 확보
- 테스트 가능한 코드 작성
- 각 컴포넌트의 책임 명확화

### 아이템 12: toString을 항상 재정의하라

**Car 클래스의 toString 재정의:**
```java
@Override
public String toString() {
    return name.toString() + " : " + "-".repeat(position);
}
```

**CarName 클래스의 toString 재정의:**
```java
@Override
public String toString() {
    return value;
}
```

**적용 이유:**
- 객체의 상태를 명확하게 표현
- 디버깅 및 로깅 용이성 향상
- 가독성 있는 출력 제공

**얻은 효과:**
- 디버깅 시간 단축
- 코드 가독성 향상
- 객체 상태 파악이 쉬움

## 3. 객체지향 설계 원칙 적용

### getter/setter 지양 및 Tell, Don't Ask 원칙

**행동 중심 메서드 설계:**
```java
// getter 대신 행동 중심 메서드 사용
public boolean isAtPosition(int position) {
    return this.position == position;
}

// 외부에서 상태 확인 후 판단하는 대신 객체에게 판단 위임
public boolean hasTraveledFartherThan(Car other) {
    return this.position > other.position;
}
```

**적용 이유:**
- 객체의 캡슐화 강화
- 객체의 자율성 증진
- 데이터 중심이 아닌 행동 중심 설계 지향

**얻은 효과:**
- 객체 간 결합도 감소
- 코드의 응집도 향상
- 객체의 책임과 역할 명확화

### 캡슐화와 정보 은닉

**상태 검증 로직 캡슐화:**
```java
private static void validateName(String name) {
    if (name.length() > NAME_LIMIT_LENGTH) {
        throw new IllegalArgumentException(NAME_ERROR.toString());
    }
}
```

**내부 구현 은닉:**
```java
// Cars 클래스에서 racers 리스트 방어적 복사
public List<Car> getRacers() {
    return new ArrayList<>(racers);
}
```

**적용 이유:**
- 구현 세부사항 은닉
- 변경 영향 범위 최소화
- 객체 내부 상태 보호

**얻은 효과:**
- 유지보수성 향상
- 코드 변경의 영향 범위 제한
- 버그 발생 가능성 감소

## 4. 설계 개선 과정

### 초기 설계의 문제점
- 도메인 객체와 뷰 간 직접적인 결합
- getter/setter 남용으로 인한 캡슐화 약화
- 전략 패턴 미적용으로 인한 확장성 부족

### 개선된 설계
- 패키지 구조 개선으로 관심사 분리
- 도메인 모델과 뷰 사이에 DTO 도입
- 의존성 주입을 통한 결합도 감소
- 불변 객체 도입으로 상태 관리 안정화

**DTO를 통한 계층 분리:**
```java
public class RoundResultDto {
    private final List<String> carProgress;

    public RoundResultDto(List<String> carProgress) {
        this.carProgress = carProgress;
    }

    public String formatResult() {
        return String.join("\n", carProgress);
    }
}
```

## 5. 테스트 용이성

### 전략 패턴을 활용한 테스트
```java
// 테스트용 전략 구현체
public class AlwaysMoveStrategy implements MovementStrategy {
    @Override
    public boolean shouldMove() {
        return true;
    }
}

// 테스트 코드
@Test
void carShouldMoveWhenStrategyReturnsTrue() {
    Car car = Car.create(CarName.from("test"), 0);
    Car movedCar = car.move(new AlwaysMoveStrategy());
    
    assertEquals(1, movedCar.getPosition());
}
```

### 의존성 주입을 통한 격리된 테스트
```java
@Test
void raceShouldFindCorrectWinner() {
    // 테스트용 뷰와 전략 주입
    View testView = new TestView();
    MovementStrategy testStrategy = new PredictableStrategy();
    
    RaceManager manager = new RaceManager(testView, testStrategy);
    // 테스트 실행 및 검증...
}
```

## 6. 결론 및 추가 개선 가능성

### 적용한 이펙티브 자바 원칙 요약
- 아이템 1: 생성자 대신 정적 팩터리 메서드를 고려하라
- 아이템 5: 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라
- 아이템 12: toString을 항상 재정의하라
- 아이템 17: 변경 가능성을 최소화하라

### 추가 적용 가능한 원칙들
- 아이템 11: equals를 재정의하려거든 hashCode도 재정의하라
- 아이템 34: int 상수 대신 열거 타입을 사용하라
- 아이템 50: 적시에 방어적 복사본을 만들라
- 아이템 54: null이 아닌, 빈 컬렉션이나 배열을 반환하라
