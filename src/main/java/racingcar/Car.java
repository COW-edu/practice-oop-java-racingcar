package racingcar;

import java.util.Random;

public class Car {
    private String name;
	private int position = 0;
	
	public Car(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name.trim();
	}
	
	public void move() {
		Random rand = new Random();
		if(rand.nextInt(10) > 3) {
			this.position++;
		}
	}
	
	public void status() {
		System.out.print(this.name + " : ");
		for(int i = 0; i < this.position; i++) {
			System.out.print("-");
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPosition() {
		return this.position;
	}
}
