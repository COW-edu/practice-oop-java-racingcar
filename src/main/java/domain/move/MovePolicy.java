package domain.move;

import camp.nextstep.edu.missionutils.Randoms;

public class MovePolicy {
  private static final int DEFAULT_MOVE_NUMBER = 4;

  public boolean canMove() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    return randomNumber >= DEFAULT_MOVE_NUMBER;
  }
}