package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarStatus;
import racingcar.dto.GameResult;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.constant.GameConstants.*;

public class RaceTrack {

    private final List<Car> cars = new ArrayList<>();

    public RaceTrack(List<String> carNames) {
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveAllCars() {
        for(Car car : cars) {
            if(shouldMove()) {
                car.move();
            }
        }
    }

    public GameResult determineWinner() {
        int maxPosition = findMaxPosition();
        List<String> winnerNames = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return new GameResult(winnerNames);
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MIN_MOVE_THRESHOLD;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<CarStatus> getCarStatuses() {
        return cars.stream()
                .map(Car::getCarStatus)
                .toList();
    }
}
