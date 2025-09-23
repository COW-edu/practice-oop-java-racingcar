package racingcar;

public class Application {
    public static void main(String[] args) {
        InputOutput inputOut = new InputOutput();

        String[] carNames = inputOut.readCarNames();
        int driveCount = inputOut.readDriveCount();
        int carCount = carNames.length;

        Car[] cars = new Car[carCount]; // car 생성
        for(int i =0; i < carCount; i++){
            cars[i] = new Car(carNames[i]); // 초기화
        }
        // 여기에 그대로 쓰면 너무 지저분해진다. 따로 빼자....

        for(int i =0; i <driveCount; i++){
            inputOut.printRoundResult(getRoundResult(cars, carCount));
        }

        inputOut.printWinner(getWinner(cars, carCount, driveCount));

    }

    private static int[] getRoundResult(Car[] cars, int carCount){
        int[] roundResult = new int[carCount];

        for(int i =0; i < carCount; i++){
            cars[i].update();
            roundResult[i] = cars[i].getMoveCount();
        }
        return roundResult;
    }
/*
    private static String[] getWinner(Car[] cars, int carCount){ // 과연 인덱스 반환? vs 네임 반환??
        String[] winner;
        int[] moveCount = new int[carCount];

        for(int i =0; i < carCount; i++){
            moveCount[i] = cars[i].getMoveCount();
        }
        int max = moveCount[0];
        int min = moveCount[0];

        for(int i =1; i < moveCount.length; i++){
            if(moveCount[i] >= )
        }
    }*/

    private static String[] getWinner(Car[] cars, int carCount, int driveCount){
        String[] winner = new String[carCount]; // max index = 전체

        int maxMove = driveCount; // 최댓값은 차피 모든 거리를 주행한 것.
        int winnerIndex = 0;

        for(int i = maxMove; i >=0; i--){
            for(int j =0; j < carCount; j++){
                if(cars[j].getMoveCount() == i){
                    winner[winnerIndex] = cars[j].getCarName(); // car에 넣어줌.
                    winnerIndex++;
                }
            }
            if(winnerIndex > 0) break;
        }

        return winner; // winner에 값이 없으면 지워야 함...
    }

}
