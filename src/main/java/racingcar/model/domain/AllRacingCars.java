package racingcar.model.domain;

import java.util.List;


public class AllRacingCars {

    private final List<RacingCar> cars;

    public AllRacingCars(List<String> carNames) {
        this.cars = convertToRacingCar(carNames);
    }

    public void playOneRound(GameRecords gameRecords, int round) {
        Game game = new Game();
        for (RacingCar car : cars) {
            game.play(car);
        }
        gameRecords.record(round, game);
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
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
}
