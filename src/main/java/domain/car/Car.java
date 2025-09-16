package domain.car;

import static common.ErrorMessages.NAME_EMPTY;
import static common.ErrorMessages.NAME_LENGTH;
import static common.ErrorMessages.NAME_REQUIRED;

import domain.move.MovePolicy;

public class Car {

  private int distance;
  private final String name;

  private Car(String name) {
    this.distance = 0;
    this.name = name;
  }

  public static Car of(String name) {
    if (name == null) {
      throw new IllegalArgumentException(NAME_REQUIRED);
    }
    if (name.isEmpty()) {
      throw new IllegalArgumentException(NAME_EMPTY);
    }
    if (name.contains(" ")) {
      throw new IllegalArgumentException(NAME_EMPTY);
    }
    if (name.length() > 5) {
      throw new IllegalArgumentException(NAME_LENGTH);
    }
    return new Car(name);
  }

  public void moveCar(MovePolicy policy) {
    if (policy.canMove()) {
      distance++;
    }
  }

  public String getName() {
    return name;
  }

  public int getDistance() {
    return distance;
  }
}