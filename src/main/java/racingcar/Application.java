package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.print("자동차 이름들을 ,를 사용해 입력하세요(이름은 5자 이하): ");
        String inputNames = Console.readLine();
        String[] carNames = inputNames.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            if (carNames[i].isEmpty() || carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
            }
        }

        System.out.print("시도 횟수 : ");
        String tryCountInput = Console.readLine();
        int tryCount = Integer.parseInt(tryCountInput);

        if (tryCount <= 0) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }

        int[] positions = new int[carNames.length];

        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carNames.length; j++) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    positions[j]++;
                }
                System.out.println(carNames[j] + " : " + "-".repeat(positions[j]));
            }
            System.out.println();
        }

        int maxDistance = 0;
        for (int pos : positions) {
            if (pos > maxDistance) {
                maxDistance = pos;
            }
        }

        // 우승자 문자열 만들기
        String winners = "";
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxDistance) {
                if (!winners.isEmpty()) {
                    winners += ",";
                }
                winners += carNames[i];
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + winners);
    }
}
