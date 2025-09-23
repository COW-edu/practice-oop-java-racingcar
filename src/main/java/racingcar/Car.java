package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int moveCount;

    Car(String name){
        carName = name;
        moveCount = 0;
    }

    void init(String name){
        carName = name;
        moveCount = 0;
    }

    private void moveForward(){
        moveCount++;
    }

    private boolean isCarMove(){
        int decisionNumber = Randoms.pickNumberInRange(0,9);

        if( decisionNumber >=4 ) return true;
        else return false;
    }

    /*
    초기 구상이었으나, 출력값이 횟수 별로 기록되어야 하기 때문에 이 방법은 그리 좋지 않음.
    void update(int count) {
        for (int i = 0; i < count; i++) {
            if (isCarMove()) moveForward();
        }
    }*/

    void update(){
        if(isCarMove()) moveForward();
    }

    // getter/ setter
    void setCarName(String name){
        carName = name;
    }

    String getCarName(){
        return carName;
    }

    int getMoveCount(){
        return moveCount;
    }

}
