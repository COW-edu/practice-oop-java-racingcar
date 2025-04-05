package racingcar.domain.model;

public class RacingCar {
    private final String name;
    private String winning = null;

    public RacingCar(String name) {
        this.name = name;
    }

    public void validateName() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void move(RacingMachine racingMachine) {
        if (racingMachine.isMoveable()) {
            winning += "-";
        }
    }

    public String getName() {
        return name;
    }

    public String getWinning() {
        return winning;
    }
}
