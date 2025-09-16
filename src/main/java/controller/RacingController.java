package controller;

import common.ErrorMessages;
import domain.car.Cars;
import service.RacingGame;
import view.InputView;
import view.OutputView;

public class RacingController {

  private final InputView inputView = new InputView();
  private final OutputView outputView = new OutputView();

  public void run() {

    outputView.askCarNames();
    String namesRaw = inputView.readCarNames();
    Cars cars = Cars.of(namesRaw);

    outputView.askRoundCount();
    String roundsRaw = inputView.readRoundCount();
    int rounds = parsePositiveInt(roundsRaw);

    RacingGame game = new RacingGame(cars);

    outputView.printResult();
    for (int i = 0; i < rounds; i++) {
      game.playOneRound();
      outputView.printRound(cars);
    }

    outputView.printWinners(cars.findWinners());
  }

  private int parsePositiveInt(String raw) {
    if (raw == null || raw.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.NUMBER_OF_MOVES);
    }

    try {
      int n = Integer.parseInt(raw.trim());
      if (n <= 0) {
        throw new IllegalArgumentException(ErrorMessages.NUMBER_OF_MOVES);
      }
      return n;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessages.NUMBER_OF_MOVES);
    }
  }
}