package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class AllRacingCars {

    private final List<RacingCar> cars;

    public AllRacingCars(List<String> carNames) {
        this.cars = convertToRacingCar(carNames);
    }

    public void playOneRound(GameRecords gameRecords, int round, Game game) {
        for (RacingCar car : cars) {
            game.play(car);
        }
        gameRecords.record(round, game);
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }
}
