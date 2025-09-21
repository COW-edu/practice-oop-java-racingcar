package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

	public static String[] name() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return scanner.nextLine().split(",");
	}
	
	public static int count() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String tryNum = scanner.nextLine();
		try {
			if(tryNum.trim().isEmpty()) {
				throw new IllegalArgumentException("시도 횟수는 빈 칸일 수 없습니다.");
			}
			int num = Integer.parseInt(tryNum.trim());
			if (num < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return num;
		} catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

	}
	
	public static void roundPrint(ArrayList<Car> cars) {
		for(Car car : cars) {
			car.status();
			System.out.println();
		}
		System.out.println();
	}
	
	public static void getWinner(ArrayList<Car> cars) {
		int maxPosition = 0;
		for(Car car : cars) {
			if(car.getPosition() >= maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		
		ArrayList<String> winners = new ArrayList<>();
		for(Car car : cars) {
			if(car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		
		System.out.print("최종 우승자 : ");
		String result = String.join(", ", winners);
		System.out.println(result);
	}
    
}
