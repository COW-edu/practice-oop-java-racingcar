package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class AllRacingCars {

    private final List<RacingCar> cars;

    public AllRacingCars(List<String> carNames) {
        this.cars = convertToRacingCar(carNames);
    }

    public void play(GameRecords gameRecords, int round, Game game) {
        for (RacingCar car : cars) {
            if (Randoms.pickNumberInRange(0,9) > 4) {
                game.move(car);
            }
        }
        gameRecords.record(round, game);
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }
}
