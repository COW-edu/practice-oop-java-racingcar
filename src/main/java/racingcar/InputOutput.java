package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputOutput {
    private int carCount = 0;
    private String[] carNames;

    public String[] readCarNames(){
        System.out.print("차량들의 이름을 입력하세요: ( ,로 구별해주세요.)");
        String names = Console.readLine();
        carNames = names.split(", ");

        carCount = carNames.length;

        if(carCount <=1 ) throw new IllegalArgumentException("차량의 이름을 2개 이상 입력해주세요.");

        return carNames;
    }

    public int readDriveCount(){ // 횟수가 1 이상의 정수여야 함. done
        System.out.print("횟수를 입력하세요: ");
        String input = Console.readLine();

        try{
            carCount = Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("type error: 1 이상의 정수를 입력해주세요.");
        }

        if(carCount <= 0) throw new IllegalArgumentException("0보다 큰 정수여야 합니다.");

        return carCount;
    }

    public void printRoundResult(int[] moveCount){
        for(int i =0; i < carCount; i++){
            System.out.print(carNames[i] + " : " );
            for(int j =0; j < moveCount[i]; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(String[] winnerList){
        if(winnerList.length == 1) System.out.println("최종 우승자: " + winnerList[0]);
        else {
            System.out.print("최종 우승자: " + winnerList[0]);
            for(int i = 1; i < winnerList.length; i++) System.out.print(", " + winnerList[i]);
        }
    }

    public int getCarCount() {
        return carCount;
    }

}
