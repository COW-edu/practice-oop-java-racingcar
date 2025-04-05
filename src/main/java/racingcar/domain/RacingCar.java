package racingcar.domain;

public class RacingCar {


    private final String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public void validateName() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
    public String getName() {
        return name;
    }
    public void move() {

    }
}
