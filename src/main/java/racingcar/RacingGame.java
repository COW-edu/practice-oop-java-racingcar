package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    
    public RacingGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }
    
    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
    
    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }
    
    public void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }
    
    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        
        return winners;
    }
    
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
    
    public void printWinners() {
        List<String> winners = getWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
