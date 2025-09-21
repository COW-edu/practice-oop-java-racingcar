package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String[] carList = View.name();
		int num = View.count();
		
		ArrayList<Car> cars = new ArrayList<>();
		for(String name : carList) {
			cars.add(new Car(name));
		}
		
		System.out.println("실행 결과\n");
		
		for(int i = 0; i < num; i++) {
			for (Car car : cars) {
                car.move();
            }
			View.roundPrint(cars);
		}
		
		View.getWinner(cars);
	}
	
}

