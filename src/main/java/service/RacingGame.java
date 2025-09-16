package service;

import domain.car.Cars;
import domain.move.MovePolicy;

public class RacingGame {
  private final Cars cars;
  private final MovePolicy policy = new MovePolicy();

  public RacingGame(Cars cars) {
    this.cars = cars;
  }

  public void playOneRound() {
    cars.moveAll(policy);
  }
}