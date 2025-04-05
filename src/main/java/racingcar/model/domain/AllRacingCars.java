package racingcar.model.domain;

import static racingcar.common.ErrorMessage.ERROR_SINGLE_RACING_CAR_NAME;

import java.util.List;


public class AllRacingCars {

    private final List<RacingCar> cars;

    public AllRacingCars(List<String> carNames) {
        List<RacingCar> cars = convertToRacingCar(carNames);
        validate(cars);
        this.cars = cars;
    }

    public void playOneRound(GameRecords gameRecords, int round) {
        Game game = new Game();
        for (RacingCar car : cars) {
            game.play(car);
        }
        gameRecords.record(round, game);
    }

    public FinalWinners getFinalWinners() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        List<RacingCar> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();

        return new FinalWinners(winners);
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }

    private void validate(List<RacingCar> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(ERROR_SINGLE_RACING_CAR_NAME);
        }
    }
}
