package racingcar.domain.model;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        validateNameLength();
        validateNameEmpty();
        this.name = name;
        this.position = 0;
    }

    private void validateNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private void validateNameEmpty() {
        if (name == null) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다.");
        }
    }

    public void move() {
        position ++;
    }

    public String getName() {
        return name;
    }


}
