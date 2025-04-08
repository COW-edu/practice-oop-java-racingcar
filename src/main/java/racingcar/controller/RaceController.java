package racingcar.controller;

import racingcar.domain.model.*;
import racingcar.domain.model.dto.FinalWinnerDTO;
import racingcar.domain.model.dto.RoundResultDTO;
import racingcar.global.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceController implements Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void execute() {
        RacingCars racingCars = inputName();
        Race race = raceProcess(racingCars);
        printResult(race);
    }

    private void printResult(Race race) {
        String finalResult = FinalWinnerDTO.from(race).getWinnersAsString();
        outputView.printWinningResult(finalResult);
    }

    private Race raceProcess(RacingCars racingCars) {
        outputView.printTryNumberNotice();
        TryNumber tryNumber = validateInputTryNumber(inputView.inputTryNumber());
        Race race = null;
        for (int i = 1; i <= tryNumber.getTryNumber(); i++) {
            race = Race.create(racingCars, tryNumber);
            outputView.printRoundResult(RoundResultDTO.from(race.startRace(),race));
        }
        return race;
    }

    private RacingCars inputName() {
        outputView.printInitialName();
        RacingCars racingCars = RacingCars.create(createRacingCars());
        return racingCars;
    }


    private List<RacingCar> createRacingCars() {
        return Arrays.stream(inputView.inputName().split(","))
                .map(String::trim)
                .map(RacingCar::create)
                .collect(Collectors.toList());
    }


    private TryNumber validateInputTryNumber(String tryNumber) {
        try {
            if (tryNumber.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
            }
            return TryNumber.from(Integer.parseInt(tryNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }

    }
}