package domain.car;

import static common.ErrorMessages.NAME_DUPLICATION;
import static common.ErrorMessages.NAME_REQUIRED;

import domain.move.MovePolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

  private final List<Car> values;

  private Cars(List<Car> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Cars of(String raw) {
    if (raw == null || raw.isEmpty()) {
      throw new IllegalArgumentException(NAME_REQUIRED);
    }

    String[] parts = raw.split(",");

    Set<String> seen = new HashSet<>();
    for (String p : parts) {
      if (!seen.add(p)) {
        throw new IllegalArgumentException(NAME_DUPLICATION + ": " + p);
      }
    }

    List<Car> list = new ArrayList<>();
    for (String name : parts) {
      list.add(Car.of(name));
    }
    return new Cars(list);
  }

  public void moveAll(MovePolicy policy) {
    values.forEach(c -> c.moveCar(policy));
  }

  public List<Car> asList() {
    return values;
  }

  public List<Car> findWinners() {
    List<Car> winners = new ArrayList<>();
    int max = 0;
    for (Car car : values) {
      int d = car.getDistance();
      if (d > max) {
        winners.clear();
        winners.add(car);
        max = d;
      } else if (d == max) {
        winners.add(car);
      }
    }
    return winners;
  }
}