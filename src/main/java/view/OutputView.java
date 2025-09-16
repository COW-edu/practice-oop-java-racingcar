package view;

import common.ErrorMessages;
import domain.car.Car;
import domain.car.Cars;
import java.util.List;

public class OutputView {

  public void askCarNames() {
    System.out.println(ErrorMessages.ASK_CAR_NAMES);
  }

  public void askRoundCount() {
    System.out.println(ErrorMessages.ASK_ROUND_COUNT);
  }

  public void printResult() {
    System.out.println();
    System.out.println(ErrorMessages.PRINT_RESULT);
  }

  public void printRound(Cars cars) {
    List<Car> list = cars.asList();
    for (Car car : list) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
    System.out.println();
  }

  public void printWinners(List<Car> winners) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < winners.size(); i++) {
      sb.append(winners.get(i).getName());
      if (i < winners.size() - 1) {
        sb.append(", ");
      }
    }
    String names = sb.toString();
    System.out.println(ErrorMessages.WINNER_ANNOUNCEMENT + names);
  }
}